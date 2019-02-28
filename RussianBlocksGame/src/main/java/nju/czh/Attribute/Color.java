package nju.czh.Attribute;

import javafx.scene.image.Image;

public enum Color {
    RED("red.png"),
    YELLOW("yellow.png"),
    GREEN("green.png"),
    BLUE("blue.png"),
    PINK("pink.png");

    final private Image image;
    Color(String path) {
        image = new Image(path);
    }

    public Image getImage() {
        return image;
    }
}
