package socket.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/31
 * @CLASSNAME
 * @description
 */
public class ServerTest {
    public static void main(String[] args) {
        ServerSocket ss;
        try {
            ss = new ServerSocket(8888);
            System.out.println("服务器即将启动，等待客户端的连接...");
            Socket so = null;
            //记录客户端的数量
            int count = 0;
            //循环侦听等待客户端的连接
            while (true) {
                so = ss.accept();
                //创建一个新的线程
                ServerThread st = new ServerThread(so);
                //启动线程，执行与客户端的交互
                st.start();//注意是start不是run
                count++;
                System.out.println("此时客户端数量为：" + count);
                InetAddress add = so.getInetAddress();
                System.out.println("当前客户端的ip地址为" + add.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
