package Swing;

//import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MyJFrame extends JFrame {

    public static Container container;

    public static void MyJFrame(MyJButton jb) {
        String title = "抽取一个幸运儿周末加班";
        JFrame jf = new JFrame(title);//实例化一个JFrame对象
        container = jf.getContentPane();//获取一个容器
        JLabel jl = new JLabel("抽选一个幸运儿周末加班!", JLabel.CENTER);//创建一个JLabel标签
        URL url = Thread.currentThread().getContextClassLoader().getResource("kdy.png");
        Icon icon = new ImageIcon(url);
        jl.setIcon(icon);
        jl.setHorizontalAlignment(SwingConstants.CENTER);//标签文字居中
        container.add(jl);//将标签添加到容器中
        container.setBackground(Color.white);//设置容器背景颜色
        jf.setVisible(true);//窗体可视化
        jf.setSize(800, 600);//设置窗体大小(长,宽)
        new MyJButton();
        container.add(jb);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//退出应用程序默认窗体关闭
    }
}
