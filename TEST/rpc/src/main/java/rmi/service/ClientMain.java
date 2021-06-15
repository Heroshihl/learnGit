package rmi.service;

import java.rmi.Naming;

/**
 * @author shihl
 * @date 2020/9/9 11:03
 * @description 5、客户端的启动就相对比较简单，我们仅需要进入服务，并调用对应的远程方法即可。
 */
public class ClientMain {
    public static void main(String[] args) throws Exception {
        //服务引入
        MyService myService = (MyService) Naming.lookup("rmi://localhost:8866/myService");
        //调用远程方法
        System.out.println("RMI 服务端调用返回：" + myService.say("MySelf"));
    }

}
