package Http;

import cn.hutool.json.JSONObject;

import java.util.Date;

/**
 * Created by zengyouzu on 2019/9/3.
 */
public class HttpTest {

    public static void main(String[] args) throws Exception {
        String url = "http://www.baidu.com";
        JSONObject request = new JSONObject();
        System.out.println(HuToolHttpUtil.post(url, request, "", ""));
    }
}
