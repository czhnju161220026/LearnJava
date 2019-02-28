package nju.czh.Things;

public class GameField {
    private Block[][] blocks = new Block[15][10];

    public GameField() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                blocks[i][j] = new Block();
                blocks[i][j].clean();
            }
        }
    }

    public void eraseColumn(int index) {
        synchronized (blocks) {
            for (int i = index; i > 0; i--) {
                for (int j = 0; j < 10; j++) {
                    if (blocks[i - 1][j].isEmpty()) {
                        blocks[i][j].clean();
                    } else {
                        blocks[i][j].setColor(blocks[i - 1][j].getColor());
                    }
                }
            }
            for (int j = 0; j < 10; j++) {
                blocks[0][j].clean();
            }
        }
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    public void clean() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                blocks[i][j].clean();
            }
        }
    }

}
