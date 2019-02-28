package nju.czh.Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import nju.czh.Attribute.Dircetions;
import nju.czh.Attribute.Position;
import nju.czh.Things.Block;
import nju.czh.Things.GameField;
import nju.czh.Things.Shape;
import nju.czh.Things.ShapeGenerator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GameRound implements Runnable {
    private boolean dead = false;

    private Shape currentShape = ShapeGenerator.generateShape();
    private Shape nextShape = ShapeGenerator.generateShape();
    private GameField gameField = new GameField();
    private Queue<Integer> eraseColumns = new LinkedList<>();
    private GraphicsContext gameAreaGC, interactiveAreaGC;
    private Image background = new Image("background.png");
    private Image background2 = new Image("background2.png");
    private Image explode = new Image("explode.png");
    private ExecutorService shapesLauncher = Executors.newSingleThreadExecutor();
    private int goals = 0;
    public GameRound(GraphicsContext gc1, GraphicsContext gc2) {
        gameAreaGC = gc1;
        interactiveAreaGC = gc2;
    }

    public void shapeMove(Dircetions dircetion) {
        currentShape.move(dircetion);
    }

    public void endGame() {
        System.out.println("End Game");
        dead = true;
    }
    //TODO: implement init() and draw()
    private void init() {
        Shape.setGameField(gameField);
        Shape.setEraseColumns(eraseColumns);
        shapesLauncher.execute(new Runnable() {
            @Override
            public void run() {
                ExecutorService service = Executors.newSingleThreadExecutor();
                while(!dead) {
                    service.execute(currentShape);
                    service.shutdown();
                    while(!service.isTerminated()) {}
                    goals += currentShape.getGoals();
                    if(goals % 7 == 0 && goals != 0) {
                        Shape.speedUp();
                    }
                    if(currentShape.isGameOver()) {
                        dead = true;
                    }
                    else {
                        currentShape = nextShape;
                        nextShape = ShapeGenerator.generateShape();
                        drawNextShape();
                        drawGoals();
                    }
                    service =  Executors.newSingleThreadExecutor();
                }
            }
        });
        shapesLauncher.shutdown();
    }
    private void drawNextShape() {
        interactiveAreaGC.drawImage(background2,0,0,275,560);
        for(Position position : nextShape.getPositions()) {
            int x = position.getX() + 50;
            int y = position.getY() + 50;
            interactiveAreaGC.drawImage(nextShape.getColor().getImage(),x,y,50,50);
        }
    }
    private void drawGoals() {
        interactiveAreaGC.setStroke(Color.WHITE);
        interactiveAreaGC.strokeText(new Integer(goals*100).toString(),50,300);
    }
    private void draw() {
        Block[][] blocks = gameField.getBlocks();
        drawNextShape();
        drawGoals();
        while(!dead) {
            try {
                gameAreaGC.drawImage(background,0,0,500,750);
                synchronized (eraseColumns) {
                    if(!eraseColumns.isEmpty()) {
                        Integer index = eraseColumns.remove();
                        for(int j = 0;j < 10;j++) {
                            gameAreaGC.drawImage(explode,j*50,index*50,50,50);
                        }
                    }
                }
                for(int i = 0;i < 15;i++) {
                    for(int j = 0;j<10;j++) {
                        if(!blocks[i][j].isEmpty()) {
                            gameAreaGC.drawImage(blocks[i][j].getColor().getImage(),new Position(i,j).getX(),new Position(i,j).getY(),50,50);
                        }
                    }
                }
                TimeUnit.MILLISECONDS.sleep(50);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public void run() {
        init();
        draw();
        System.out.println("QUit");
    }
}
