package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class MyFrame extends JFrame {

    public MyFrame(String title) {
        JFrame jf = new JFrame(title);//实例化一个JFrame对象
        Container container = jf.getContentPane();//获取一个容器
        JLabel jl = new JLabel("抽选一个幸运儿周末加班!", JLabel.CENTER);//创建一个JLabel标签
        URL url = Thread.currentThread().getContextClassLoader().getResource("kdy.png");
        Icon icon = new ImageIcon(url);
        jl.setIcon(icon);
        jl.setHorizontalAlignment(SwingConstants.CENTER);//标签文字居中
        container.add(jl);//将标签添加到容器中
        container.setBackground(Color.white);//设置容器背景颜色
        jf.setVisible(true);//窗体可视化
        jf.setSize(800, 600);//设置窗体大小(长,宽)

        JButton jb = new JButton("点击开始抽选");
        jb.setMaximumSize(new Dimension(90, 30));
        jb.setHideActionText(true);
        jb.setToolTipText("图片按钮");
        jb.setBorderPainted(true);
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                new MyJDialog;
            }
        });
        container.add(jb);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//退出应用程序默认窗体关闭
    }

    public static void main(String[] args) throws Exception {
        new MyFrame("抽选一个幸运儿周末加班!");
    }
}
