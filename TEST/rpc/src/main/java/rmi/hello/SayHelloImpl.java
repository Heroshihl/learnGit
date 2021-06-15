package rmi.hello;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author shihl
 * @date 2020/9/9 10:04
 * @description 2）实现我们这个远程接口并且继承 UnicastRemoteObject
 * 你可以理解为它是一个发布出去供他人调用的类, 当UserServiceImpl实现了这个类后,
 * UserServiceImpl就能被发布出去供别人调用.
 */
public class SayHelloImpl extends UnicastRemoteObject implements SayHello {
    protected SayHelloImpl() throws RemoteException {
    }

    protected SayHelloImpl(int port) throws RemoteException {
        super(port);
    }

    protected SayHelloImpl(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello LLF -->"+name;
    }
}
