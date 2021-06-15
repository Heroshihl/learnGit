package concurrentcollaboration.productionandconsumption.sankeixingzang;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/22
 * @CLASSNAME
 * @description
 */
public class ShareResource {
    private String name;
    private String gender;

    // 新增加一个标志位，表示共享资源是否为空，默认为 true
    private boolean isEmpty = true;

    /**
     * 模拟生产者
     * 向共享资源对象中存储数据 * * @param name * @param gender
     */
    public synchronized void push(String name, String gender) {
        try {
            while (!isEmpty) {
                // 当前共享资源不为空的时，则等待消费者来消费
                // 使用同步锁对象来调用，表示当前线程释放同步锁，进入等待池，只能被其他线程所唤醒
                this.wait();
            }
            // 开始生产
            this.name = name;
            Thread.sleep(10);
            this.gender = gender;
            // 生产结束
            isEmpty = false;
            // 生产结束唤醒一个消费者来消费
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 模拟消费者
     * 从共享资源中取出数据
     */
    public synchronized void popup() {
        try {
            while (isEmpty) {
                // 为空则等着生产者进行生产
                // 使用同步锁对象来调用，表示当前线程释放同步锁，
                // 进入等待池，只能被其他线程所唤醒
                this.wait();
            }
            // 消费开始
            Thread.sleep(10);
            System.out.println(this.name + "-" + this.gender);
            // 消费结束
            isEmpty = true;
            // 消费结束唤醒一个生产者去生产
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 创建生产者和消费者的共享资源对象
        ShareResource shareResource = new ShareResource();
        // 启动生产者线程
        new Thread(new Producer(shareResource)).start();
        // 启动消费者线程
        new Thread(new Consumer(shareResource)).start();
    }
}
