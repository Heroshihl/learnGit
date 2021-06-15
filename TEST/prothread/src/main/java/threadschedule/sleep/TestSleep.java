package threadschedule.sleep;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/22
 * @CLASSNAME
 * @description Java线程：线程的调度-休眠
 *
 * 结果输出可以看出，无法精准保证线程执行次序。
 */
public class TestSleep {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        Thread thread = new Thread(new MyRunnable());
        myThread1.start();
        thread.start();
    }
}
