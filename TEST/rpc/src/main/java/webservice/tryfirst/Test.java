package webservice.tryfirst;

/**
 * @author shihl
 * @date 2020/9/9 16:26
 * @description
 */
public class Test {
    public static void main(String[] args) {
        UserServiceImplService implService = new UserServiceImplService();
        UserServiceImpl service = implService.getUserServiceImplPort();
        String hello = service.sayHello("再加两串腰子");
        System.out.println(hello);
    }
}
