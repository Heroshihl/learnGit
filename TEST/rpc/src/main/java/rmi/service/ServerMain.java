package rmi.service;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

/**
 * @author shihl
 * @date 2020/9/9 11:01
 * @description
 */
public class ServerMain {
    public static void main(String[] args) throws Exception {
        //注册服务
        LocateRegistry.createRegistry(8866);
        //指定通信端口，防止被防火墙拦截
        RMISocketFactory.setSocketFactory(new CustomerSocketFactory());
        //创建服务
        MyService myService = new MyServiceImpl();
        Naming.bind("rmi://localhost:8866/myService",myService);
        System.out.println("RMI 服务端启动正常");
    }
}
