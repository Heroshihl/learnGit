package publishorshare;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/24
 * @CLASSNAME
 * @description 可以让一组线程相互等待，当每个线程都准备好之后，所有线程才继续执行的工具类
 */
public class CyclicBarrierTest {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
        System.out.println("ready done callback!");
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    System.out.println(finalI + "ready!");
                    cyclicBarrier.await();
//                    cyclicBarrier.await(2000, TimeUnit.MILLISECONDS); // 如果某个线程等待超过2秒就报错
                    System.out.println(finalI + "go!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        }
    }
}
