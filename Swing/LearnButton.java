import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Button1 extends  JFrame {
    JButton b1;
    JButton b2;
    JTextField jTextField;
    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Trigger: "+((JButton)e.getSource()).getText());
            jTextField.setText("你按下了:"+((JButton)e.getSource()).getText());
        }
    }
    Listener buttonListener = new Listener();
    public  Button1() {
        super("按钮测试");
        b1 = new JButton("按钮1");
        b2 = new JButton("按钮2");
        jTextField = new JTextField(10);
        b1.addActionListener(buttonListener);
        b2.addActionListener(buttonListener);
        b1.setOpaque(true);
        b1.setBackground(Color.CYAN);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(jTextField);
        setSize(200,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

public class LearnButton {
    static  Button1 button1;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                button1 = new Button1();
            }
        });
    }
}
