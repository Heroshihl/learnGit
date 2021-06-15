package multithreading;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/21
 * @CLASSNAME
 * @description
 */
public class TestRunnable {
    public static void main(String[] args) {
        RunnableImpl runnable1 = new RunnableImpl("李白");
        RunnableImpl runnable2 = new RunnableImpl("杜甫");
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
    }
}
