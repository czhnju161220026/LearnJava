package nju.czh.Attribute;

public class Position {
    private int i, j, x, y;

    public Position(int i, int j) {
        this.i = i;
        this.j = j;
        this.x = j * 50;
        this.y = i * 50;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
        this.y = i * 50;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
        this.x = j * 50;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        this.j = x / 50;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        this.i = y / 50;
    }
}
