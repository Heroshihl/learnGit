package threadsynchronization.method;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/22
 * @CLASSNAME
 * @description
 */
public class MyThread extends Thread{
    private User user;
    private int y = 0;

    public MyThread(String name,User user, int y) {
        super(name);
        this.user = user;
        this.y = y;
    }

    @Override
    public void run() {
        user.oper(y);
    }
}
