package rmi.hello;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author shihl
 * @date 2020/9/9 10:05
 * @description 3)创建服务器程序 调用createRegistry方法注册远程对象
 */
public class HelloServer {
    public static void main(String[] args) {
        try {
//            实例化远程对象
            SayHelloImpl hello = new SayHelloImpl();
//            绑定端口
            LocateRegistry.createRegistry(8888);
            try {
//                绑定url，注册远程对象
                Naming.bind("rmi://localhost:8888/sayHello",hello);
                System.out.println("Server start success!");
            } catch (AlreadyBoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
