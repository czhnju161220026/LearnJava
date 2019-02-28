package nju.czh.Things;

import nju.czh.Attribute.Color;
import nju.czh.Attribute.Dircetions;
import nju.czh.Attribute.Position;
import nju.czh.Attribute.ShapeCategory;

import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;


public class Shape implements Runnable {
    private static Block[][] blocks = null;
    private static GameField gameField = null;
    private static Queue<Integer> eraseColumns = null;
    private static Integer interval = 800;
    private ShapeCategory category;
    private Color color;
    private Position[] positions = new Position[4];
    private boolean end = false;
    private boolean gameOver = false;
    private int goals = 0;
    private Integer deltaI = -3;
    private Integer deltaJ = 5;
    private int mode = 0;

    public Shape(Color color, ShapeCategory category) {
        this.color = color;
        this.category = category;
        this.positions = category.getPositions(0);
    }

    public static void setGameField(GameField gameField) {
        Shape.gameField = gameField;
        Shape.blocks = gameField.getBlocks();
    }

    public static void speedUp() {
        if(interval > 600) {
            interval-=50;
        }
    }

    public static void setEraseColumns(Queue<Integer> queue) {
        eraseColumns = queue;
    }

    private boolean isConflict(int deltaI, int deltaJ) {
        for (Position position : positions) {
            int i = position.getI() + deltaI;
            int j = position.getJ() + deltaJ;
            if (i >= 15 || j < 0 || j >= 10 ) {
                System.out.println("Conflict");
                return true;

            }
            if(i>=0 && !blocks[i][j].isEmpty()) {
                boolean self = false;
                for(Position position1 : positions) {
                    int i1 = position1.getI() + this.deltaI;
                    int j1 = position1.getJ() + this.deltaJ;
                    if(i == i1 && j == j1) {self = true;}
                }
                if(!self) {
                    System.out.println("Conflict");
                    return  true;
                }
            }
        }
        return false;
    }

    private void leave() {
        for (Position position : positions) {
            int i = position.getI() + deltaI;
            int j = position.getJ() + deltaJ;
            if (i >= 0 && i < 15 && j >= 0 && j < 10) {
                blocks[i][j].clean();
            }
        }
    }

    private void enter() {
        for (Position position : positions) {
            int i = position.getI() + deltaI;
            int j = position.getJ() + deltaJ;
            if (i >= 0 && i < 15 && j >= 0 && j < 10) {
                blocks[i][j].setColor(color);
            }
        }
    }

    private void erase() {
        Set<Integer> columns = new TreeSet<>();
        for (Position position : positions) {
            int i = position.getI() + deltaI;
            if (i >= 0 && i < 15) {
                columns.add(i);
            } else {
                gameOver = true;
                end = true;
                return;
            }
        }
        for (Integer i : columns) {
            boolean full = true;
            for (int j = 0; j < 10; j++) {
                if (blocks[i][j].isEmpty()) {
                    full = false;
                }
            }
            if (full) {
                synchronized (eraseColumns) {
                    eraseColumns.add(i);
                }
                gameField.eraseColumn(i);
                goals += 1;
            }
        }
    }

    private void change() {
        synchronized (blocks) {
            int nextMode = (mode + 1) % 4;
            positions = category.getPositions(nextMode);
            if (!isConflict(deltaI, deltaJ)) {
                positions = category.getPositions(mode);
                leave();
                positions = category.getPositions(nextMode);
                mode = nextMode;
                enter();
            } else {
                positions = category.getPositions(mode);
            }
        }
    }

    //图形移动判断
    public void move(Dircetions dircetion) {
        System.out.println("Shape move:" + dircetion);
        synchronized (blocks) {
            if(end) {
                return;
            }
            if (dircetion == Dircetions.UP) {
                change();
                return;
            } else {
                if (dircetion == Dircetions.RIGHT) {
                    synchronized (deltaJ) {
                        Integer nextDeltaJ = deltaJ + 1;
                        if (!isConflict(deltaI, nextDeltaJ)) {
                            leave();
                            deltaJ = nextDeltaJ;
                            enter();
                        }
                    }
                } else if (dircetion == Dircetions.LEFT) {
                    synchronized (deltaJ) {
                        Integer nextDeltaJ = deltaJ - 1;
                        if (!isConflict(deltaI, nextDeltaJ)) {
                            leave();
                            deltaJ = nextDeltaJ;
                            enter();
                        }
                    }
                } else if (dircetion == Dircetions.DOWN) {
                    synchronized (deltaI) {
                        Integer nextDeltaI = deltaI + 1;
                        if (!isConflict(nextDeltaI, deltaJ)) {
                            leave();
                            deltaI = nextDeltaI;
                            enter();
                        } else {
                            end = true;
                            erase();
                        }
                    }
                }
            }
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getGoals() {
        return goals;
    }

    public Position[] getPositions() {
        return positions;
    }

    public Color getColor() {
        return  color;
    }
    public void run() {
        //enter();
        while (!end) {
            try {
                synchronized (blocks) {
                    synchronized (deltaI) {
                        int nextDeltaI = deltaI + 1;
                        if (!isConflict(nextDeltaI, deltaJ)) {
                            leave();
                            deltaI = nextDeltaI;
                            enter();
                        } else {
                            System.out.println("Conflict when fall");
                            end = true;
                            erase();
                        }
                    }
                }
                TimeUnit.MILLISECONDS.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
