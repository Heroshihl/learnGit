package threadinteraction;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/21
 * @CLASSNAME 线程的交互
 * @description 当程序走到b.start时，又新开了一个栈用来执行B，A和B是分开的两个栈，独立运行
 * 此处应该充分理解线程栈模型与线程的变量
 */
public class ThreadA {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        //启动计算线程 重开一个栈用来运行线程B  A和B并行运行
        b.start();
        //线程A拥有b对象上的锁。线程为了调用wait()或notify()方法，该线程必须是那个对象锁的拥有者
        synchronized (b) {
            try {
                System.out.println("等待对象b完成计算......");
                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b对象计算的总和是：" + b.total);
        }
    }
}
