package nju.czh.Things;


import nju.czh.Attribute.Color;
import nju.czh.Attribute.ShapeCategory;

import java.util.Random;

public class ShapeGenerator {
    private static Random random = new Random();

    public static Shape generateShape() {
        int color = random.nextInt(10000) % 5;
        int category = random.nextInt(10000) % 7;
        return new Shape(Color.values()[color], ShapeCategory.values()[category]);
    }
}
