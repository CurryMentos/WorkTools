package Http;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import cn.hutool.json.JSONObject;

/**
 * Created by andy on 2019/7/4.
 */
public class HuToolHttpUtil {

    public static JSONObject post(String url, JSONObject parameter, String headerName, String token) throws Exception {
        HttpRequest httpRequest = HttpUtil.createPost(url).header(headerName, token).timeout(5000);
        if (parameter != null) {
            httpRequest.body(parameter);
            System.out.println("�������:" + parameter);
        }
        HttpResponse response = httpRequest.execute();
        if (response.isOk()) {
            System.out.println("������:" + response.body());
            return new JSONObject(response.body());
        }
        System.out.println("post����ʧ��!" + response.getStatus() + response.body());
        return null;
    }

    public static JSONObject get(String url, String headerName, String token) throws Exception {
        HttpResponse response = HttpUtil.createGet(url).header(headerName, token).timeout(5000).execute();
        if (response.isOk()) {
            System.out.println("������:" + response.body());
            return new JSONObject(response.body());
        }
        System.out.println("get����ʧ��!" + response.getStatus());
        return null;
    }

    public static JSONObject delete(String url, String headerName, String token) throws Exception {
        HttpResponse response = HttpUtil.createRequest(Method.DELETE, url).header(headerName, token).timeout(5000).execute();
        if (response.isOk()) {
            System.out.println("������:" + response.body());
            return new JSONObject(response.body());
        }
        System.out.println("delete����ʧ��!" + response.getStatus());
        return null;
    }

    public static JSONObject put(String url, String headerName, String token, JSONObject parameter) throws Exception {
        HttpResponse response = HttpUtil.createRequest(Method.PUT, url).header(headerName, token).body(parameter).timeout(5000).execute();
        System.out.println("�������:" + parameter);
        if (response.isOk()) {
            System.out.println("������:" + response.body());
            return new JSONObject(response.body());
        }
        System.out.println("put����ʧ��!" + response.getStatus());
        return null;
    }

}
