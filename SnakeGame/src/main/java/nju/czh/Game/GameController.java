package nju.czh.Game;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import nju.czh.Attribute.Direction;
import nju.czh.Being.Snake;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameController implements Initializable {
    @FXML private Canvas gameArea;
    @FXML private AnchorPane anchorPane;
    private boolean isGaming = false;
    private GameRound gameRound ;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GraphicsContext gc = gameArea.getGraphicsContext2D();
        Image background = new Image("background.png");
        gc.drawImage(background,0,0,1000,800);
        gc.setStroke(Color.RED);
        gc.strokeText("按空格键开始游戏",400,50); //绘制帧数
        gameArea.setOnKeyPressed(new KeyBoardHandler());
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                gameArea.requestFocus();
            }
        });
    }

    private void startGame() {
        isGaming = true;
        Stage stage = (Stage)anchorPane.getScene().getWindow();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                quitGameHandler();
                System.exit(0);
            }
        });
        GraphicsContext gc = gameArea.getGraphicsContext2D();
        gc.drawImage(new Image("background.png"),0,0,1000,800);
        System.out.println("游戏开始");
        ExecutorService executorService = Executors.newCachedThreadPool();
        gameRound = new GameRound(gameArea.getGraphicsContext2D());
        executorService.execute(gameRound);
        executorService.shutdown();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                gameArea.requestFocus();
            }
        });
    }

    private void quitGameHandler() {
        if(isGaming) {
            gameRound.endGame();
        }
    }
    class KeyBoardHandler implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            if(event.getCode() == KeyCode.SPACE && !isGaming) {
                startGame();
            }
            if(isGaming) {
                if(event.getCode() == KeyCode.RIGHT) {
                    Snake.setDirection(Direction.RIGHT);
                }
                else if(event.getCode() == KeyCode.LEFT) {
                    Snake.setDirection(Direction.LEFT);
                }
                else if(event.getCode() == KeyCode.DOWN) {
                    Snake.setDirection(Direction.DOWN);
                }
                else if(event.getCode() == KeyCode.UP) {
                    Snake.setDirection(Direction.UP);
                }
                System.out.println(event.getCode());
            }
        }
    }
}
