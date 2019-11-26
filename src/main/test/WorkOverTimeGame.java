//import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zengyouzu on 2019/11/14.
 */
public class WorkOverTimeGame {
    public static List Testers() {
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

    public static String RandomChoose() {
        List testersList = Testers();
        int i = new Random().nextInt(testersList.size());
        String str = testersList.get(i).toString();
        return str;
    }

    public static void main(String[] args) {
        System.out.println("恭喜" + RandomChoose() + "同学喜提周末加班");
    }
}