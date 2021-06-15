package rmi.user;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author shihl
 * @date 2020/9/9 10:29
 * @description
 */
public class User_Stub extends User {
    private Socket socket;

    public User_Stub() {
        try {
//            通过ip和端口连接到指定的服务器
            socket=new Socket("localhost", 8888);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getAge(){
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        try {
            oos=new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("age");
            oos.flush();

            ois=new ObjectInputStream(socket.getInputStream());
            return ois.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
                oos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return 0;
    }
}
