package publishorshare;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/24
 * @CLASSNAME
 * @description 由于同时获取3个许可，所以有即使开启了100个线程，但是每秒只能执行3个任务
 */
public class CountDownLatchTest2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //配置只能发布3个运行许可证
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire(5); //获取3个运行许可，如果获取不到会一直等待，使用tryAcquire则不会等待
                    Thread.sleep(5000);
                    System.out.println(finalI);
                    semaphore.release(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
