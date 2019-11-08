package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zengyouzu on 2019/7/16.
 * JFrame窗体
 */
class MyJDialog extends JDialog {
    public MyJDialog(MyFrame frame) {
        super(frame, "第一个JDialog窗体", true);
        Container container = getContentPane();
        container.add(new JLabel("这是一个对话框"));
        setBounds(120, 120, 100, 100);
    }
}

public class MyFrame extends JFrame {

    public MyFrame() {
        Container container = getContentPane();
        container.setLayout(null);
        JLabel jl = new JLabel("阿祖帅气逼人");
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(jl);
        JButton jb = new JButton("点赞");
        jb.setBounds(10, 10, 100, 21);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyJDialog(MyFrame.this).setVisible(true);
            }
        });
        container.add(jb);
    }

    public static void main(String[] args) throws Exception{
        new MyFrame();
    }
}
