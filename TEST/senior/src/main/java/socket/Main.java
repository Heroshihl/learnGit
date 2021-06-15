package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/31
 * @CLASSNAME
 * @description
 */
public class Main {
    public static void main(String[] args)
            throws Exception {
        URL url = new URL("http://www.runoob.com/html/html-tutorial.html");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:data.html"));
        String line;
//        抓取网页
        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
            writer.write(line);
            writer.newLine();
        }
//        获取 URL响应头的日期信息：
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        long date = httpCon.getDate();
        if (date == 0) {
            System.out.println("无法获取信息。");
        } else {
            System.out.println("Date: " + new Date(date));
            System.out.println("===============================");
        }
//        获取指定 URL 的响应头信息：
        Map<String, List<String>> headerFields = httpCon.getHeaderFields();
        for (Map.Entry<String, List<String>> ss:headerFields.entrySet()) {
            System.out.println(ss.getKey());
            System.out.println(ss.getValue());
            System.out.println("===================================");
        }

        System.out.println("URL 是 " + url.toString());
        System.out.println("协议是 " + url.getProtocol());
        System.out.println("文件名是 " + url.getFile());
        System.out.println("主机是 " + url.getHost());
        System.out.println("路径是 " + url.getPath());
        System.out.println("端口号是 " + url.getPort());
        System.out.println("默认端口号是 " + url.getDefaultPort());
        reader.close();
        writer.close();
    }
}
