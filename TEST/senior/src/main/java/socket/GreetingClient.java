package socket;

import java.io.*;
import java.net.Socket;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/30
 * @CLASSNAME
 * @description 如下的 GreetingClient 是一个客户端程序，
 * 该程序通过 socket 连接到服务器并发送一个请求，然后等待一个响应。
 * <p>
 * 1、创建Socket对象，指明需要连接的服务器的地址和端口号
 * <p>
 * 2、连接建立后，通过输出流向服务器端发送请求信息
 * <p>
 * 3、通过输入流获取服务器相应的信息
 * <p>
 * 4、关闭相关资源。
 */
public class GreetingClient {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 8888;
        System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
        try {
/**           1、创建Socket对象，指明需要连接的服务器的地址和端口号*/
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
/**2、连接建立后，通过输出流向服务器端发送请求信息*/
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF("客户端: Hello from" + client.getLocalSocketAddress());
/**3、通过输入流获取服务器相应的信息*/
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());
//4、关闭相关资源。
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
