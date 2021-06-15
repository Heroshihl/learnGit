package rmi.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author shihl
 * @date 2020/9/9 10:00
 * @description 1）创建远程接口并且继承java.rmi.Remote 接口
 */
public interface SayHello extends Remote {
    public String sayHello(String name)throws RemoteException;
}
