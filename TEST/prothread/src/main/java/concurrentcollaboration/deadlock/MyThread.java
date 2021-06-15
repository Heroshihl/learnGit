package concurrentcollaboration.deadlock;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/22
 * @CLASSNAME
 * @description
 */
public class MyThread extends Thread {
    private DeadlockRisk dead;
    private int a, b;

    MyThread(DeadlockRisk dead, int a, int b) {
        this.dead = dead;
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        dead.read();
        dead.write(a, b);
    }
}
