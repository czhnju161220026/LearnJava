package nju.czh.Being;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import nju.czh.Attribute.Position;

public class Food {
    private Position position = new Position(0,0);
    private Image food = new Image("food.png");
    public Food() {
        position.setX(0);
        position.setY(0);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void display(GraphicsContext gc) {
        gc.drawImage(food,position.getX()*40,position.getY()*40,40,40);
    }
}
