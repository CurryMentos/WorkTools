package Http;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * Created by zengyouzu on 2019/9/3.
 */
public class HttpTest {
    public static void login(String username,String password) throws Exception {
        //打印结果
        boolean flag = false;
        //定义url
        String url = "http://192.168.159.166/ac_portal/addisclaimer/pc.html?template=addisclaimer&tabs=pwd&vlanid=0&urlip=192.168.0.22&_ID_=6106&switch_url=&url=http://www.baidu.com/s?ie=utf-8";
        JSONObject request = new JSONObject();
        request.put("曾佑祖",username);
        request.put("Aa1234!#",password);
        System.out.println("请求:" + request.toString());
        String respone = HttpMethod.httpPost(url,request.toString(),"","",flag);
        JSONObject obj  = JSONObject.parseObject(respone);
        JSONObject data = (JSONObject) obj.get("data");
        String token = data.get("token").toString();
        System.out.println(data.get("token"));
    }

    public static void loginTest()throws Exception{
        //打印结果
        boolean flag = false;
        //定义url
        String url = "http://192.168.159.166/ac_portal/addisclaimer/pc.html?template=addisclaimer&tabs=pwd&vlanid=0&urlip=192.168.0.22&_ID_=6106&switch_url=&url=http://www.baidu.com/s?ie=utf-8";
        JSONObject request = new JSONObject();

        String userName = "曾佑祖";
        String password = "Aa1234!#";
        request.put("username",userName);
        request.put("password",password);

        System.out.println("请求:" + request.toString());

        String respone = HttpMethod.httpPost(url,request.toString(),"","",flag);

        System.out.println(respone);
    }

    public static void main(String[] args) throws Exception{
        Long l = new Date().getTime();
        System.out.println(l);
    }
}
