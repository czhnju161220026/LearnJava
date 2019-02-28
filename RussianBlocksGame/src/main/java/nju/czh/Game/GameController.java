package nju.czh.Game;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import nju.czh.Attribute.Dircetions;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameController implements Initializable {
    @FXML
    private Canvas gameArea;
    @FXML
    private Canvas interactiveArea;
    @FXML
    private AnchorPane mainPane;

    private Image background = new Image("background.png");
    private boolean isGaming = false;
    private GameRound gameRound;
    private ExecutorService gameLauncher = Executors.newSingleThreadExecutor();

    class InnerController implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent event) {
            if (event.getCode() == KeyCode.SPACE && !isGaming) {
                newRoundHandler();
                return;
            }
            if (event.getCode() == KeyCode.ESCAPE && isGaming) {
                endGameHandler();
                return;
            }

            if (isGaming) {
                if (event.getCode() == KeyCode.UP) {
                    gameRound.shapeMove(Dircetions.UP);
                } else if (event.getCode() == KeyCode.DOWN) {
                    gameRound.shapeMove(Dircetions.DOWN);
                } else if (event.getCode() == KeyCode.LEFT) {
                    gameRound.shapeMove(Dircetions.LEFT);
                } else if (event.getCode() == KeyCode.RIGHT) {
                    gameRound.shapeMove(Dircetions.RIGHT);
                }
            }
        }
    }

    private void newRoundHandler() {
        Stage stage = (Stage)mainPane.getScene().getWindow();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                endGameHandler();
            }
        });
        isGaming = true;
        gameArea.getGraphicsContext2D().drawImage(background,0,0,500,750);
        gameRound = new GameRound(gameArea.getGraphicsContext2D(), interactiveArea.getGraphicsContext2D());
        gameLauncher.execute(gameRound);
        gameLauncher.shutdown();
    }

    private void endGameHandler() {
        isGaming = false;
        gameRound.endGame();
        while(!gameLauncher.isTerminated()) {}
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GraphicsContext gc = gameArea.getGraphicsContext2D();
        gc.drawImage(background, 0, 0, 500, 750);
        gc.setStroke(Color.WHITE);
        gc.strokeText("空格键开始游戏", 200, 50);
        gc.strokeText("方向键操纵方块",200,70);
        gc = interactiveArea.getGraphicsContext2D();
        gc.drawImage(background, 0, 0, 275, 750);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                gameArea.requestFocus();
                gameArea.setOnKeyPressed(new InnerController());
            }
        });
    }
}
