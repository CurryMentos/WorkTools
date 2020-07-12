import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zengyouzu on 2019/6/13.
 */
public class CreatePassword {
    public static char GetRandomChar(char char1, char char2) {
        return (char) (char1 + Math.random() * (char2 - char1 + 1));
    }

    @Test
    public static void test() {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(GetRandomChar('a', 'z'));//小写字母
        }
        list.add(GetRandomChar('A', 'Z'));//大写字母
        list.add(GetRandomChar('0', '9'));//数字
        list.add(GetRandomChar('!', '*'));//特殊字符
        //打乱顺序
        Collections.shuffle(list);
        // 生成随机密码
        for (Character pwd : list) {
            System.out.print(pwd);
        }
    }
}
