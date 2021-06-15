package rmi.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author shihl
 * @date 2020/9/9 10:56
 * @description 2、对于接口实现类，RMI接口方法定义必须显式声明抛出RemoteException异常，
 * 服务端方法实现必须继承UnicastRemoteObject类，该类定义了服务调用与服务提供方对象实现，并建立一对一的连接。
 */
public class MyServiceImpl extends UnicastRemoteObject implements MyService {
    protected MyServiceImpl() throws RemoteException {
    }

    @Override
    public String say(String someOne) throws RemoteException {
        return someOne + ",Welcome to Study!";
    }
}
