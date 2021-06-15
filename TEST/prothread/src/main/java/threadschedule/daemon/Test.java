package threadschedule.daemon;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/22
 * @CLASSNAME
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Thread t1=new MyCommon();
        Thread t2=new Thread(new MyDaemon());
        //设置为守护线程
        t2.setDaemon(true);
        t2.start();
        t1.start();
    }
}
