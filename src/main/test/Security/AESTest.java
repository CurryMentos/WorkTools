package Security;

import org.testng.annotations.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Created by zengyouzu on 2019/12/3.
 */
public class AESTest {
    //生成密钥
    public static SecretKey generateKey(String password) throws Exception {
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        //生成一个128位的随机源,根据传入的字节数组
        keygen.init(128, new SecureRandom(password.getBytes()));
        //产生原始对称密钥
        SecretKey secretKey = keygen.generateKey();
        //获得原始对称密钥的字节数组
        byte[] raw = secretKey.getEncoded();
        //根据字节数组生成AES密钥
        SecretKey key = new SecretKeySpec(raw, "AES");

        return key;
    }

    //加密
    public static byte[] AESEncode(String message, SecretKey key) throws Exception {
        //根据指定算法AES创建密码器
        Cipher cipher = Cipher.getInstance("AES");
        //初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
        cipher.init(Cipher.ENCRYPT_MODE, key);
        //获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
        byte[] EncodeByte = message.getBytes("utf-8");
        //根据密码器的初始化方式加密
        byte[] EncodeResult = cipher.doFinal(EncodeByte);

        return EncodeResult;
    }

    //解密
    public static String AESDecode(byte[] message, SecretKey key) throws Exception {
        //根据指定算法AES创建密码器
        Cipher cipher = Cipher.getInstance("AES");
        //初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
        cipher.init(Cipher.DECRYPT_MODE, key);
        //根据密码器的初始化方式解密
        byte[] DecodeByte = cipher.doFinal(message);
        String DecodeResult = new String(DecodeByte);

        return DecodeResult;
    }

    @Test
    public static void test() throws Exception {
        String message = "工资";//明文
        String password = "1234";//密文
        SecretKey secretKey = generateKey(password);//密钥
        /*String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println("密钥:" + encodedKey);
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        System.out.println("原始数据:" + AESDecode(encodedKey.getBytes(), secretKey));*/

        byte[] result = AESEncode(message, secretKey);//加密后结果
        System.out.println(message + "编码后的字符串为:" + result);
        System.out.println(result + "解码后的字符串为:" + AESDecode(result, secretKey));
    }
}
