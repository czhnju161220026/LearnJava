package nju.czh.Things;


import nju.czh.Attribute.*;

public class Block {
    private Color color = null;
    private boolean isEmpty = true;

    public void clean() {
        isEmpty = true;
        color = null;
    }

    public void setColor(Color color) {
        this.color = color;
        isEmpty = false;
    }

    public Color getColor() {
        return color;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
