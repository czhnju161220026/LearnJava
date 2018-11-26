import javax.swing.*;
import java.awt.*;

//通过提交runnable，可以避免在main中直接操作控件
class SwingSubmitProgram extends JFrame{
    JLabel jLabel;
    public SwingSubmitProgram() {
        super("This is a window");
        jLabel = new JLabel("this is a lable");
        add(jLabel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,200);
        setVisible(true);
    }

    public void change() {
        jLabel.setText("Now , it is different!");
    }
}

public class LearnSwing {
    static SwingSubmitProgram swingSubmitProgram;
    public static  void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                swingSubmitProgram = new SwingSubmitProgram();
            }
        });

        Thread.sleep(1000);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                swingSubmitProgram.change();
            }
        });
    }
}
