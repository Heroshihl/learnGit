package rmi.user;

/**
 * @author shihl
 * @date 2020/9/9 10:27
 * @description
 */
public class UserServer extends User {
    public static void main(String[] args) {
        UserServer server=new UserServer();
        server.setAge(18);
        //模拟rmi生成的skeleton代理对象
        User_Skeleton user_Skeleton=new User_Skeleton(server);
        user_Skeleton.start();

    }
}
