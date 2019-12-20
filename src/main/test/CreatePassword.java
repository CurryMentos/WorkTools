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
//        list.add(GetRandomChar('!', '*'));//特殊字符
        //打乱顺序
        Collections.shuffle(list);
        // 生成随机密码
        for (Character pwd : list) {
            System.out.print(pwd);
        }
    }

    public static void main(String[] args) {
        int array[] = new int[]{15, 21, 17, 3, 69, 40};
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - 1 - i];
            array[length - 1 - i] = temp;
        }
        for (int i : array) {
            System.out.println(i);
        }
    }
}
