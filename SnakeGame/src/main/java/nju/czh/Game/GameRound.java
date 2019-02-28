package nju.czh.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import  nju.czh.Being.*;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GameRound implements Runnable {
    private Snake snake = new Snake();
    private Food food = Feeder.feed(snake);
    private GraphicsContext gc;
    private Image background = new Image("background.png");


    public GameRound(GraphicsContext gc) {
        this.gc = gc;
    }

    public void endGame() {
        snake.die();
    }
    public void run() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        snake.findFood(food);
        executorService.execute(snake);
        executorService.shutdown();
        while(!snake.isDead()) {
            try {
                gc.drawImage(background,0,0,1000,800);
                snake.display(gc);
                food.display(gc);
                TimeUnit.MILLISECONDS.sleep(50);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
