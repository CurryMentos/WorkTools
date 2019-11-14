package Security;

import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.Test;

import javax.crypto.Cipher;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zengyouzu on 2019/11/1.
 * RSA非对称加密解密
 */
public class RSATest {
    static Map<String, String> keyMap = new HashMap<String, String>();//用于封装随机产生的公钥与私钥
    static String OriginStr = "麒超是渣男";//原始字符串
    static String EncodedStr = "LFia1+YUG2Dmvh/pt62IobyTUxzlKKPA+uuJzUQbs/JIA0qoFZGPfGoacrcwBknTvBAlvGwonUtKqTfCDZVl9A==";//加密后的字符串
    static String privateKeyString = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEA2O0u8yiwlm7p+V7Ja4wQNHjcBsGC4SkyNKK8Wf+ANFsOuSoMd5EddQUe/BdbTVVJ2Chxcw1JKCRbshqReOD6FQIDAQABAkBLaVD8CTYyZcaDAXemIp/zjdx3oMgd/FNOxxARfWgVSrqf36BVIz7ycOdKJ1SqOEL3OOiTCpSoVYQpDTdlzB6BAiEA67IHljUKGKgZpjmF8KOoQ4npFezPpgcs6+2XPNSAcrUCIQDrnTpwLwDSJmt4GLA9gjEbZBqSWPqGeg7y7J92Lsgl4QIhAM6pc22JZCjqfFL77S1q0oclzXKkCg6SDBlyYkG8MkRhAiEApy82szm3BGc8pMgn7k0+WShL7oJyqg9cIiWi9PI3FSECICtEOhq6vVy5cygF6CKdowo7F+/14X+zzJzOyjilsdhu\n";//私钥

    public static void main(String[] args) throws Exception {
        DoEncode();
//        DoDecode();
    }

    //加密方法
    public static void DoEncode() throws Exception {
        GenerateKeyPair();
        System.out.println("随机生成的公钥为:" + keyMap.get("publicKey"));
        System.out.println("随机生成的私钥为:" + keyMap.get("privateKey"));
        String EncodeStr = encrypt(OriginStr, keyMap.get("publicKey"));
        System.out.println("加密后的字符串为:" + EncodeStr);
        String DecodeStr = decrypt(EncodeStr, keyMap.get("privateKey"));
        System.out.println("解密后的字符串为:" + DecodeStr);
    }

    //解密方法
    public static void DoDecode() throws Exception {
        keyMap.put("privateKey", privateKeyString);
        System.out.println(EncodedStr + "解密后的字符串为:" + decrypt(EncodedStr, keyMap.get("privateKey")));
    }

    public static void GenerateKeyPair() throws Exception {
        //基于RSA算法生成公钥和私钥对
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        //初始化密钥大小,至少512bit
        kpg.initialize(512, new SecureRandom());
        //生成一个密钥对，保存在keyPair中
        KeyPair keyPair = kpg.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();//得到公钥
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();//得到私钥
        String publicKeyString = new String(Base64.encodeBase64(rsaPublicKey.getEncoded()));//得到公钥字符串
        String privateKeyString = new String(Base64.encodeBase64((rsaPrivateKey.getEncoded())));//得到私钥字符串
        // 将公钥和私钥保存到Map
        keyMap.put("publicKey", publicKeyString);//公钥
        keyMap.put("privateKey", privateKeyString);//私钥
        FileWriter PublicKeyFileWriter = new FileWriter("RSAPublicKey.txt");
        BufferedWriter EncodebufferedWriter = new BufferedWriter(PublicKeyFileWriter);
        EncodebufferedWriter.write(publicKeyString);
        EncodebufferedWriter.close();
        FileWriter PrivateKeyFileWriter = new FileWriter("RSAPrivateKey.txt");
        BufferedWriter DecodebufferedWriter = new BufferedWriter(PrivateKeyFileWriter);
        DecodebufferedWriter.write(privateKeyString);
        DecodebufferedWriter.close();
    }

    //RSA公钥加密
    public static String encrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey rsaPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));//按照X.509标准编码
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, rsaPublicKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        FileWriter EncodefileWriter = new FileWriter("RSAEncode.txt");
        BufferedWriter EncodebufferedWriter = new BufferedWriter(EncodefileWriter);
        EncodebufferedWriter.write(outStr);
        EncodebufferedWriter.close();
        return outStr;
    }

    //RSA私钥解密
    public static String decrypt(String str, String privateKey) throws Exception {
        //base64解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));//按照PKCS8标准编码
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
        String outStr = new String(cipher.doFinal(inputByte));
        FileWriter DecodefileWriter = new FileWriter("RSADecode.txt");
        BufferedWriter DecodebufferedWriter = new BufferedWriter(DecodefileWriter);
        DecodebufferedWriter.write(outStr);
        DecodebufferedWriter.close();
        return outStr;
    }
}
