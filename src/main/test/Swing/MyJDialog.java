package Swing;

import javax.swing.*;
import java.awt.*;

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
