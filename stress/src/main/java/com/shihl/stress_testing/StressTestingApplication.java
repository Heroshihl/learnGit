package com.shihl.stress_testing;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ApplicationRunner实现springboot应用启动后做一些初始化操作，实现它的run方法即可
 * @author 石华磊
 */
@Slf4j
@SpringBootApplication
@AllArgsConstructor
@NoArgsConstructor
public class StressTestingApplication implements ApplicationRunner {
    @Value("${rest.threadCount}")
    private int threadCount;
    @Value("${rest.url}")
    private String url;
    @Value("${rest.runCount}")
    private int runCount;
    @Value("${rest.jsonFile}")
    private String jsonFile;
    @Value("${rest.method}")
    private String method;

    public static void main(String[] args) {
        log.info("StressTestingApplication is starting ...");
        SpringApplication.run(StressTestingApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("threadCount : {}", this.threadCount);
        log.info("url : {}", this.url);
        log.info("runCount : {}", this.runCount);
        log.info("jsonFile : {}", this.jsonFile);
        log.info("method : {}", this.method);
        ThreadPoolExecutor taskExecutor = new ThreadPoolExecutor(
                this.threadCount, this.threadCount, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue(this.threadCount), new ThreadPoolExecutor.CallerRunsPolicy());
        final String jsonData = readJsonFromFile(this.jsonFile);
        final Map<String, String[]> queryparams = new HashMap();
        final List<String> header = new ArrayList();
        long begin = System.currentTimeMillis();
        (new StressTestingApplication.StatThread(taskExecutor)).start();
        /**
         * CountDownLatch能够使一个线程在等待另外一些线程完成各自工作之后，再继续执行。使用一个计数器进行实现。
         * 计数器初始值为线程的数量。当每一个线程完成自己任务后，计数器的值就会减一。当计数器的值为0时，
         * 表示所有的线程都已经完成一些任务，然后在CountDownLatch上等待的线程就可以恢复执行接下来的任务。
         */
        final CountDownLatch cd = new CountDownLatch(this.runCount);

        for(int i = 0; i < this.runCount; ++i) {
            taskExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        String response = RestfullClient.sendRestfull3(StressTestingApplication.this.url,
                                StressTestingApplication.this.method, jsonData, queryparams, header);
                        StressTestingApplication.log.debug("返回值: {}", response);
                    } catch (Exception var5) {
                        StressTestingApplication.log.error("访问rest异常 : {}", var5.getMessage());
                    } finally {
                        cd.countDown();
                    }

                }
            });
        }

        try {
            cd.await();
        } catch (InterruptedException var13) {
            var13.printStackTrace();
        }

        log.info("taskExecutor : {}", taskExecutor);
        taskExecutor.shutdown();
        //第一个参数timeout是等待关闭线程池执行器的时间大小
        taskExecutor.awaitTermination(10L, TimeUnit.SECONDS);
        long end = System.currentTimeMillis();
        long totalTime = end - begin;
        log.info("测试结束........................");
        log.info("总次数 : {}", this.runCount);
        log.info("成功次数 : {}", RestfullClient.sendRestfullSeccessCount.get());
        log.info("失败次数 :{}", RestfullClient.sendRestfullFailedCount.get());
        log.info("秒数 : {}", (double)totalTime * 1.0D / 1000.0D);
        double var10001 = (double)this.runCount * 1.0D;
        log.info("并发/每秒 : " + var10001 / ((double)totalTime * 1.0D / 1000.0D));
        RestfullClient.client.close();
        System.exit(0);
    }

    /**
     * @param file 文件路径
     * @return
     */
    private static String readJsonFromFile(String file) {
        try {
            return Files.readString(Path.of(file));
        } catch (IOException var2) {
            throw new RuntimeException(var2);
        }
    }

    private static class StatThread extends Thread {
        private ThreadPoolExecutor taskExecutor;

        public StatThread(ThreadPoolExecutor taskExecutor) {
            this.taskExecutor = taskExecutor;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    log.info("taskExecutor : {}", this.taskExecutor);
                    Thread.sleep(1000L);
                } catch (Exception var2) {
                   log.error("StatThread异常", var2);
                }
            }
        }
    }
}
