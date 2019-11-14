
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zengyouzu on 2019/11/14.
 */
public class WorkOverTimeGame extends javax.swing.JFrame {
    private static List Testers() {
        List<String> testersList = new ArrayList<>();
        testersList.add("王麒超");
        testersList.add("李文超");
        testersList.add("曾佑祖");
        testersList.add("林南");
        testersList.add("杨威");
        testersList.add("罗宁");
        testersList.add("高文佩");
        testersList.add("单元元");
        testersList.add("梅洁");
        return testersList;
    }

    public static void Random(List testersList) {
        int i = new Random().nextInt(testersList.size());
        System.out.println(testersList.get(i));
    }

    public void CreateJFrame() {

    }
}
