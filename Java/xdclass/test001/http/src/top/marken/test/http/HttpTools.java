package top.marken.test.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author makun
 * @project test001
 * @description HTTP请求工具
 * @date 2022/08/24 10:28:41
 * version 1.0
 */
public class HttpTools {
    private HttpTools() {
        super();
    }

    public static URL getUrl(String urlStr) {
        URL url = null;

        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getContent(URL url) {
        StringBuilder sb = new StringBuilder();

        HttpURLConnection huc = null;

        try {
            huc = (HttpURLConnection) url.openConnection();
            int code = huc.getResponseCode();

            if (200 <= code && 299 >= code) {
                InputStream in = huc.getInputStream();
                BufferedReader bufReader = new BufferedReader(new InputStreamReader(in));
                String currentLine;

                while ((currentLine = bufReader.readLine()) != null) {
                    sb.append(currentLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
