package threadinteraction;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/22
 * @CLASSNAME
 * @description
 */
public class Calculator extends Thread {
    int total;
    @Override
    public void run() {
        synchronized (this) {
            for(int i=0;i<101;i++){
                total+=i;
            }
        }
        //通知所有在此对象上等待的线程
        notifyAll();
    }
}
