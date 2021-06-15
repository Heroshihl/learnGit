package rmi.user;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author shihl
 * @date 2020/9/9 10:28
 * @description 服务端 -骨干网
 */
public class User_Skeleton extends Thread {
    private UserServer userServer;

    public User_Skeleton(UserServer userServer) {
        this.userServer = userServer;

    }

    public void run() {
        ServerSocket serverSocket = null;
        ObjectInputStream read = null;
        ObjectOutputStream oos = null;
        Socket socket=null;
        try {
//            暴露一个监听端口
            serverSocket = new ServerSocket(8888);
            socket = serverSocket.accept();
            while (socket != null) {
                read = new ObjectInputStream(socket.getInputStream());
                String method = (String) read.readObject();
                if (method.equals("age")) {
                    int age = userServer.getAge();
                    oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeInt(age);
                    oos.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    oos.close();
                    read.close();
                    socket.close();
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
