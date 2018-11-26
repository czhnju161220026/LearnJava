import javax.swing.*;
import java.awt.*;

class Border extends JFrame{
    Border() {
        super("Border");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(400,400);
        add(BorderLayout.NORTH,new JButton("North"));
        add(BorderLayout.SOUTH,new JButton("South"));
        add(BorderLayout.CENTER,new JButton("Center"));
        add(BorderLayout.EAST,new JButton("East"));
        add(BorderLayout.WEST,new JButton("West"));
        setVisible(true);
    }
}

class Flow extends JFrame {
    Flow() {
        super("Flow");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(200,400);
        for(int i = 0;i < 20;i++) {
            add(new JButton("button"+i));
        }
        setVisible(true);
    }
}

class Grid extends  JFrame {
    Grid() {
        super("Grid");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(11,21));
        setSize(1470,770);
        for(int i = 0; i<11;i++) {
            for(int j = 0; j< 21;j++) {
                if(j!=10) {
                    add(new JLabel("大娃"));
                }
                else {
                    add(new JLabel("  "));
                }
            }
        }
        setVisible(true);
    }
}


public class LearnLayout {
    static Border border;
    static  Flow flow;
    static  Grid grid;
    public  static void main(String[] args) throws InterruptedException{
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                border = new Border();
                flow = new Flow();
                grid = new Grid();
            }
        });
    }
}
