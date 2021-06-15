package webservice.tryfirst;

import javax.xml.ws.Endpoint;

/**
 * @author shihl
 * @date 2020/9/9 11:43
 * @description 2、发布远程服务, 过程和rmi差不多,
 * 需要提供远程服务的访问地址和具体的远程服务实现类, 使用Endpoint类的publish()方法进行发布,
 * 这都是JDK封装好的.
 */
public class WsProviderApp {
    public static void main(String[] args) {
//发布的WebService的被访问地址
        String address = "http://localhost:9998/user";
//         //创建远程服务对象  服务一旦发布，这里代码就到服务器上了，没用了现在
//        客户端使用wsimport调用后，服务变成接口 这里好像是一个bug
//        UserService userService = new UserServiceImpl();
//        发布服务
//        Endpoint.publish(address, userService);
        System.out.println("user远程服务已经发布...");
    }
}
