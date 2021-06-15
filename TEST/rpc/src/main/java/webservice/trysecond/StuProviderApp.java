package webservice.trysecond;

import javax.xml.ws.Endpoint;

/**
 * @author shihl
 * @date 2020/9/9 16:02
 * @description 2、发布服务
 */
public class StuProviderApp {
    public static void main(String[] args) {
        //发布的WebService的被访问地址
        String address = "http://localhost:8888/stu";
        StudentServiceImpl serviceImp = new StudentServiceImpl();
        //发布服务
        Endpoint.publish(address,serviceImp);

        System.out.println("学生服务已经发布");
    }
}
