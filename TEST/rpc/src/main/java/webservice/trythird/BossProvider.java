package webservice.trythird;

import javax.xml.ws.Endpoint;

/**
 * @author shihl
 * @date 2020/9/9 16:30
 * @description
 */
public class BossProvider {
    public static void main(String[] args) {
        String address = "http://localhost:9997/boss";
//        服务发布后 服务会变成接口，不能实例化
//        Endpoint.publish(address,new BossService());
        System.out.println("Boss服务发布");
    }

}
