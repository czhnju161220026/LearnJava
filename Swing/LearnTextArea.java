import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TextArea extends JFrame{
    JTextArea textArea;
    JButton clearButton;
    JButton showButton;
    public TextArea() {
        super("This is a window");
        textArea = new JTextArea(10,30);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textArea.setText("");
                    }
                }
        );
        showButton = new JButton("Show");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change();
            }
        });
        setLayout(new FlowLayout());
        add(new JScrollPane(textArea));
        add(showButton);
        add(clearButton);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,280);
        setVisible(true);
    }
    public  void change() {
        textArea.append("我绝不承认两颗真心的结合\n" +
                "有任何障碍。这样的爱不是真爱\n" +
                "若是遇有变节的机会就改变，\n" +
                "或是被强势剥离就屈服：\n" +
                "哦，那不是爱！爱是坚定的烽火，\n" +
                "凝视着狂涛而不动摇；\n" +
                "爱是向导迷航船只的明星，\n" +
                "高度可测，实价无量。\n" +
                "爱不受时光影响，即使红唇粉颊\n" +
                "终会被岁月的镰刀砍伐；\n" +
                "爱不随分分秒秒、日日月月改变，\n" +
                "爱不畏时间磨炼，直到末日尽头。\n" +
                "如果有人可证明我所解不实，\n" +
                "我从未写过，而无人曾真爱过。");
    }
}

public class LearnTextArea {
    static TextArea textArea;
    public  static  void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                textArea = new TextArea();
                textArea.change();
            }
        });
    }
}
