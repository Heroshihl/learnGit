package threadinteraction;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/22
 * @CLASSNAME
 * @description
 * 运行结果表明，程序中有异常，并且多次运行结果可能有多种输出结果。
 * 这就是说明，这个多线程的交互程序还存在问题。
 */
public class ReaderResult extends Thread{
    Calculator c;
    public ReaderResult(Calculator c) {
        this.c = c;
    }

    @Override
    public void run() {
        synchronized (c){
            System.out.println(Thread.currentThread() + "等待计算结果");
            try {
                c.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "计算结果为: " + c.total);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        //启动三个线程，分别获取计算结果
        new ReaderResult(calculator).start();
        new ReaderResult(calculator).start();
        new ReaderResult(calculator).start();
        //启动计算线程
        calculator.start();
    }
}
