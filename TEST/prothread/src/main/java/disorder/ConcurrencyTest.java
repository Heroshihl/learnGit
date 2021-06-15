package disorder;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/23
 * @CLASSNAME
 * @description Semaphore信号量是一个能阻塞线程且能控制统一时间请求的并发量的工具。
 * 比如能保证同时执行的线程最多200个，模拟出稳定的并发量
 */
public class ConcurrencyTest {
    private static final int THREAD_COUNT = 5000;
    private static final int CONCURRENT_COUNT = 200;
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(CONCURRENT_COUNT);
//        计数器闭锁是一个能阻塞主线程，让其他线程满足特定条件下再继续执行的工具。
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(count);
    }

    private static void add(){
        count++;
    }
}
