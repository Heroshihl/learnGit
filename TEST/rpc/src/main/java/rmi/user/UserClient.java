package rmi.user;

/**
 * @author shihl
 * @date 2020/9/9 10:28
 * @description
 */
public class UserClient {
    public static void main(String[] args) {
        User user=new User_Stub();
        int age=user.getAge();
        System.out.println(age);
    }
}
