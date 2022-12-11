package top.marken.test.http;

import com.google.gson.Gson;

import java.net.URL;
import java.util.Map;

/**
 * @author makun
 * @project test001
 * @description HTTP请求测试
 * @date 2022/08/24 10:28:11
 * version 1.0
 */
public class Main {
    public static void main(String[] args) {
        String urlStr = "https://api.xdclass.net/pub/api/v1/web/is_favorite?video_id=62&token=xdclasseyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZGNsYXNzIiwicm9sZXMiOiIxLDIiLCJpbWciOiJodHRwczovL3hkLXZpZGVvLXBjLWltZy5vc3MtY24tYmVpamluZy5hbGl5dW5jcy5jb20veGRjbGFzc19wcm8vZGVmYXVsdC9oZWFkX2ltZy8yMS5qcGVnIiwiaWQiOjY3ODg1OTEsIm5hbWUiOiLmtJflv4PpnanpnaLlpb3nlLflrakiLCJpYXQiOjE2NjEzMDg2OTUsImV4cCI6MTY2MTkxMzQ5NX0.VhP_cAEN0FwFwuQeX_cEJK9p-0vOWo5ZuHcZ5or6XWQ";
        URL url = HttpTools.getUrl(urlStr);

        String content = HttpTools.getContent(url);

        Gson gson = new Gson();
        Map<String,Object> map = gson.fromJson(content, Map.class);

        System.out.println(content);
        System.out.println(map);
    }
}
