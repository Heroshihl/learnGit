package rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author shihl
 * @date 2020/9/9 10:56
 * @description 1、首先我们需要为服务端创建一个接口方法，而且这个接口最好继承Remote
 */
public interface MyService extends Remote {
    String say(String someOne)throws RemoteException;
}
