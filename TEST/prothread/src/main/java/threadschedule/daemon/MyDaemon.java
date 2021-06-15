package threadschedule.daemon;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/22
 * @CLASSNAME
 * @description
 */
public class MyDaemon implements Runnable {
    @Override
    public void run() {
        for (long i = 0; i < 9999999L; i++) {
            System.out.println("守护线程第" + i +"次执行！");
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
