package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zengyouzu on 2019/11/15.
 */
public class MyJButton extends MyJFrame{
    public static JButton MyJButton(MyJFrame frame){
//        Container container = getContentPane();
        JButton jb = new JButton("点击开始抽选");
        jb.setMaximumSize(new Dimension(90, 30));
        jb.setHideActionText(true);
        jb.setToolTipText("图片按钮");
        jb.setBorderPainted(true);
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        return jb;
    }
}
