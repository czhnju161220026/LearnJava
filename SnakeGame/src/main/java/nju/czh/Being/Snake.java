package nju.czh.Being;

import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import nju.czh.Attribute.Direction;
import nju.czh.Attribute.Position;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Snake implements Runnable{
    private static Direction direction;
    private LinkedList<Position> snakeParts = new LinkedList<>();
    private Image snake = new Image("snake.png");
    private boolean isDead = false;
    private Food food;
    public Snake() {
        snakeParts.add(new Position(12,10));
        snakeParts.add(new Position(12,11));
        snakeParts.add(new Position(12,12));
        direction = Direction.UP;
    }
    public static void setDirection(Direction direction) {
        if(direction == Direction.UP && Snake.direction!= Direction.DOWN ||
                direction == Direction.DOWN && Snake.direction!= Direction.UP||
                direction == Direction.LEFT && Snake.direction!= Direction.RIGHT||
                direction == Direction.RIGHT && Snake.direction!= Direction.LEFT)
        Snake.direction = direction;
    }
    public boolean isConflict(Position position) {
        for(Position p : snakeParts) {
            if(p.getX() == position.getX() && p.getY() == position.getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean isDead() {
        return isDead;
    }

    public void die() {
        isDead = true;
    }
    public void display(GraphicsContext gc) {
        synchronized (snakeParts) {
            for(Position p : snakeParts) {
                gc.drawImage(snake, p.getX()*40,p.getY()*40,40,40);
            }
        }
    }
    public void findFood(Food food) {
        this.food = food;
    }
    public  void run() {
        System.out.println("Snake run");
        while(!isDead) {
            synchronized (snakeParts) {
                Position head = new Position(snakeParts.get(0).getX(),snakeParts.get(0).getY());
                Position tail = new Position(snakeParts.getLast().getX(),snakeParts.getLast().getY());
                for(int i = snakeParts.size()-1;i >=1;i--) {
                    snakeParts.get(i).setX(snakeParts.get(i-1).getX());
                    snakeParts.get(i).setY(snakeParts.get(i-1).getY());
                }
                if(direction == Direction.UP) {
                    head.setY(head.getY()-1);
                }
                if(direction == Direction.DOWN) {
                    head.setY(head.getY()+1);
                }
                if(direction == Direction.LEFT) {
                    head.setX(head.getX()-1);
                }
                if(direction == Direction.RIGHT) {
                    head.setX(head.getX()+1);
                }
                if(head.getX() < 0 || head.getX() > 24 || head.getY() < 0 || head.getY() > 19 || isConflict(head)) {
                    isDead = true;
                }
                else if(head.getX() == food.getPosition().getX() && head.getY() == food.getPosition().getY()) {
                    snakeParts.add(tail);
                    food.setPosition(Feeder.feed(this).getPosition());
                }
                else {
                    snakeParts.get(0).setX(head.getX());
                    snakeParts.get(0).setY(head.getY());
                }
            }


            try {
                TimeUnit.MILLISECONDS.sleep(400);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Snake dead");
    }
}
