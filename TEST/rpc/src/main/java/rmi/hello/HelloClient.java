package rmi.hello;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author shihl
 * @date 2020/9/9 10:09
 * @description 4）创建客户端程序
 */
public class HelloClient {
    public static void main(String[] args) {
        try {
//            远程获取接口实例
            SayHello hello = (SayHello) Naming.lookup("rmi://localhost:8888/sayHello");
            System.out.println(hello.sayHello("FXP"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
