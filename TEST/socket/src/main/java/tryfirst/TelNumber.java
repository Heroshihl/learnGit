package tryfirst;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author shihl
 * @date 2020/9/10 16:33
 * @description 国内手机号码归属地查询web服务
 *
 * 可以使用已有的服务，只要提供了WSDL文件，那么客户端就能导入这些服务，然后进行调用
 * wsimport -keep -d E:\ideatest\TEST\socket\src\main\java -p trysecond http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?WSDL
 * -keep 用于保留生成的类, 如果没有该指令会只生成class文件
 * -d 后面接项目中存放这些工具类的包, 填绝对路径
 * -p 填包名 + wdsl文档的地址
 */
public class TelNumber {
    public void get(String mobileCode, String userID) throws Exception {
        URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo?mobileCode=" + mobileCode +
                "&userID=" + userID);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) { //结果码=200
            InputStream is = conn.getInputStream();
            //内存流 ，
            ByteArrayOutputStream boas = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = is.read(buffer)) != -1) {
                boas.write(buffer, 0, len);
            }
            System.out.println("GET请求获取的数据:" + boas.toString());
            boas.close();
            is.close();
        }
    }

    public static void main(String[] args) {
        TelNumber telNumber = new TelNumber();
        try {
            telNumber.get("15370811900"," ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
