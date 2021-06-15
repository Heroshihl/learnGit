package publishorshare;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/24
 * @CLASSNAME
 * @description
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//            executorService.execute(() -> System.out.println(finalI));
//        }
        executorService.scheduleAtFixedRate(() -> System.out.println("hehe"), 1, 2, TimeUnit.SECONDS);
//        executorService.shutdown();
    }
}
