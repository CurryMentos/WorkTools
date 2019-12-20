package Security;

import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/11/1.
 * Base64加密解密
 */
public class Base64Test {

    @Test
    public static void test() {
        String string = "112966";

        String encodeStr = encode(string.getBytes());
        System.out.println(string + "编码后的字符串为：" + encodeStr);

        String decodeStr = decode(encodeStr.getBytes());
        System.out.println(encodeStr + "解码后的字符串为：" + decodeStr);
    }

    //编码
    public static String encode(byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }

    //解码
    public static String decode(byte[] bytes) {
        return new String(Base64.decodeBase64(bytes));
    }

}
