package threadschedule.priority;

import threadschedule.sleep.MyRunnable;
import threadschedule.sleep.MyThread1;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/22
 * @CLASSNAME
 * @description Java线程：线程的调度-优先级 数值越大优先级越高
 */
public class TestPriority {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        Thread thread = new Thread(new MyRunnable());
        myThread1.setPriority(10);
        thread.setPriority(1);
        myThread1.start();
        thread.start();
    }
}
