package Security;

/**
 * Created by zengyouzu on 2019/10/30.
 * DES对称加密解密
 */

import org.apache.commons.codec.binary.Hex;
import org.testng.annotations.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import java.io.*;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class DESTest {

    public static void main(String[] args) {
        try {
            jdkDES();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String path = Thread.currentThread().getContextClassLoader().getResource("020.txt").getPath();
    static String OriginStr = "麒超是渣男";
    static String method = "DES";
    static byte[] keyBytes = {'z', 'y', 'z', '1', '2', '3', '4'};

    public static void jdkDES() throws Exception {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter EncodefileWriter = new FileWriter("Encode.txt");
        BufferedWriter EncodebufferedWriter = new BufferedWriter(EncodefileWriter);
        FileWriter DecodefileWriter = new FileWriter("Decode.txt");
        BufferedWriter DecodebufferedWriter = new BufferedWriter(DecodefileWriter);

        //生成KEY
        KeyGenerator keyGenerator = KeyGenerator.getInstance(method);//Key的生成器
        keyGenerator.init(56);//指定keySize,必须56
        SecretKey secretKey = keyGenerator.generateKey();
//        SecretKey secretKey = new SecretKeySpec(keyBytes, method);
        byte[] bytesKey = secretKey.getEncoded();

        //转换KEY
        DESKeySpec desKeySpec = new DESKeySpec(bytesKey);//实例化DESKey秘钥的相关内容
        SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");//实例一个秘钥工厂，指定加密方式
        Key convertSecretKey = factory.generateSecret(desKeySpec);

        //DES/ECB/PKCS5Padding--->算法/工作方式/填充方式
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");//通过Cipher这个类进行加解密相关操作

        //按行读取文件
        List<String> list = new ArrayList<String>();
        String str = null;
        try {
            while ((str = bufferedReader.readLine()) != null) {
                if (str.trim().length() > 0) {
                    list.add(str);
                    //加密
                    cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
                    byte[] EncodeResult = cipher.doFinal(str.getBytes());//输入要加密的内容
                    System.out.println("加密结果:" + Hex.encodeHexString(EncodeResult));
                    EncodebufferedWriter.write(Hex.encodeHexString(EncodeResult));
                    EncodebufferedWriter.write("\n");

                    //解密
                    cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
                    byte[] DecodeResult = cipher.doFinal(EncodeResult);
                    System.out.println("解密结果:" + new String(DecodeResult));
                    DecodebufferedWriter.write(new String(DecodeResult));
                    DecodebufferedWriter.write("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
