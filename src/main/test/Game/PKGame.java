package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zengyouzu on 2019/9/2.
 */
public class PKGame {
    public static void main(String[] args) {
        String a = "小A";
        String b = "小B";

        List<String> list1 = new ArrayList<>();
        list1.add(a + "把" + b + "按在地上暴揍一顿");
        list1.add(a + "打得" + b + "叫爸爸");
        list1.add(a + "对" + b + "使出了口臭攻击,效果拔群");
        list1.add(a + "一招泰山压顶," + b + "顿时眼前一黑");
        list1.add(a + "一套王八拳,打得" + b + "鼻青脸肿抱头鼠窜,大喊'好汉饶命'");
        list1.add(a + "按住" + b + "的狗头,疯狂输出");
        list1.add("还未动手," + a + "的气场就震慑住了" + b + "," + b + "吓出了屎");
        list1.add(a + "请" + b + "吃了一招'阿道根'");

        List<String> list2 = new ArrayList<>();
        list2.add(b + "把" + a + "按在地上暴揍一顿");
        list2.add(b + "打得" + a + "叫爸爸");
        list2.add(b + "对" + a + "使出了口臭攻击,效果拔群");
        list2.add(b + "一招泰山压顶," + a + "顿时眼前一黑");
        list2.add(b + "一套王八拳,打得" + a + "鼻青脸肿抱头鼠窜,大喊'好汉饶命'");
        list2.add(b + "按住" + a + "的狗头,疯狂输出");
        list2.add("还未动手," + b + "的气场就震慑住了" + a + "," + a + "吓出了屎");
        list2.add(b + "请" + a + "吃了一招'阿道根'");

        for (int c = 0; c < 3; c++) {
            int i = (int) (0 + Math.random() * (99 - 0 + 1));
            int j = (int) (0 + Math.random() * (99 - 0 + 1));

            if (i > j) {
                int index = new Random().nextInt(list1.size());
                System.out.println(list1.get(index));
            } else if (i < j) {
                int index = new Random().nextInt(list2.size());
                System.out.println(list2.get(index));
            } else {
                System.out.println(a + "和" + b + "大战三百回合,不分胜负");
            }
        }
    }
}
