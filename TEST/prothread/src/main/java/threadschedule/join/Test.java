package threadschedule.join;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/22
 * @CLASSNAME
 * @description 合并
 */
public class Test {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("主线程第 " + i + " 次执行");
            if(i > 2){
                try {
                    //main本身也是一条线程，线程1和main线程分开执行
                    //当main线程执行到第3次的时候，停止执行，转而执行线程1
                    //直到线程1执行完毕后再执行main剩下的
                    myThread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
