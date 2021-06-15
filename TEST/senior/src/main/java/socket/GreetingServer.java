package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/30
 * @CLASSNAME
 * @description 如下的GreetingServer 程序是一个服务器端应用程序，使用 Socket 来监听一个指定的端口。
 * 1、创建ServerSocket对象，绑定监听端口
 * <p>
 * 2、通过accept()方法监听客户端请求
 * <p>
 * 3、连接建立后，通过输入流读取客户端发送的请求信息
 * <p>
 * 4、通过输出流向客户端发送响应信息
 * <p>
 * 5、关闭相关资源
 */
public class GreetingServer extends Thread {
    private ServerSocket serverSocket;


    /**
     *1、 创建ServerSocket对象，绑定监听端口
     *
     * @param port
     * @throws IOException
     */
    public GreetingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(100000);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
            try {
                /**2、通过accept()方法监听客户端请求*/
                Socket server = serverSocket.accept();
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
/**               3、 连接建立后，通过输入流读取客户端发送的请求信息*/
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                /**4、通过输出流向客户端发送响应信息*/
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("服务器：谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");
/**               5、关闭相关资源*/
                server.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
