package nju.czh.Being;

import nju.czh.Attribute.Position;

import java.util.Random;

public class Feeder {

    public static Food feed(Snake snake) {
        Food food = new Food();
        Random random = new Random();
        while(true) {
            Position position = new Position(random.nextInt(25),random.nextInt(20));
            if(!snake.isConflict(position)) {
                food.setPosition(position);
                break;
            }
        }

        return food;
    }
}
