package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zengyouzu on 2019/7/16.
 */
public class JFrameTest extends javax.swing.JFrame {
    public void CreateJFrame(String title) {//定义一个CreateJFrame()方法
        JFrame jf = new JFrame(title);//实例化一个JFrame对象
        Container container = jf.getContentPane();//获取一个容器
        JLabel jl = new JLabel("阿祖帅气逼人");//创建一个JLabel标签
        jl.setHorizontalAlignment(SwingConstants.CENTER);//标签文字居中
        container.add(jl);//将标签添加到容器中
        container.setBackground(Color.white);//设置容器背景颜色
        jf.setVisible(true);//窗体可视化
        jf.setSize(800, 600);//设置窗体大小(长,宽)

        Icon icon = new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("kdy.png").getPath());
        setLayout(new GridLayout(1, 2));
        JButton jb = new JButton();
        jb.setMaximumSize(new Dimension(90, 30));
        jb.setIcon(icon);
        jb.setHideActionText(true);
        jb.setToolTipText("图片按钮");
        jb.setBorderPainted(true);
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "弹出对话框");
            }
        });
        container.add(jb);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//退出应用程序默认窗体关闭
    }

    public static void main(String[] args) {
        new JFrameTest().CreateJFrame("");
    }
}
