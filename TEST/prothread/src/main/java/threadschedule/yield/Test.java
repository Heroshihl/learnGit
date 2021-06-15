package threadschedule.yield;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/22
 * @CLASSNAME
 * @description Java线程：线程的调度-让步
 * 执行效果并不满意，没有看出让步的状态
 */
public class Test {
    public static void main(String[] args) {
        Thread myThread1 = new MyThread1();
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        myThread1.start();
    }
}
