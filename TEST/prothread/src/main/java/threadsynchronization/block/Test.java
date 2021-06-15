package threadsynchronization.block;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/22
 * @CLASSNAME
 * @description
 */
public class Test {
    public static void main(String[] args) {
        User user = new User("张三", 100);
        MyThread t1 = new MyThread("线程A", user, 20);
        MyThread t2 = new MyThread("线程B", user, -60);
        MyThread t3 = new MyThread("线程C", user, -80);
        MyThread t4 = new MyThread("线程D", user, -30);
        MyThread t5 = new MyThread("线程E", user, 32);
        MyThread t6 = new MyThread("线程F", user, 21);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
