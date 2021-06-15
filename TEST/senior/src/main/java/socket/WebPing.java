package socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/31
 * @CLASSNAME
 * @description
 */
public class WebPing {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("www.baidu.com", 80);
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("连接到" + inetAddress);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
