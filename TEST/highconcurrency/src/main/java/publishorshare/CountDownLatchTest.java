package publishorshare;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/24
 * @CLASSNAME
 * @description 计数器闭锁是一个能阻塞主线程，让其他线程满足特定条件下主线程再继续执行的线程同步工具。
 */
public class CountDownLatchTest {
    private static final int COUNT = 100;


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(COUNT);

        for (int i = 0; i < COUNT; i++) {
            //countDown方法的执行次数一定要与countDownLatch的计数器数量一致，否则无法将计数器清空导致主线程无法继续执行
            int finalI = i;

            executorService.execute(() -> {

                try {

                    System.out.println("第" + finalI + "次，线程先让你3秒，然后再掏出40米大刀");
                    Thread.sleep(3000);
                    System.out.println(finalI);
                    System.out.println("第" + finalI + "次睡醒了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                    System.out.println("计数器结束");
                }
            });
        }
        System.out.println("main先走啦");
        //主线程只等1秒，超过之后继续执行主线程
        countDownLatch.await(1, TimeUnit.SECONDS);
        //当正在执行的线程执行完成之后再关闭而不是立即停止线程
        executorService.shutdown();
        System.out.println("done!");
    }
}
