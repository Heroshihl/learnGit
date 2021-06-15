package multithreading;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/21
 * @CLASSNAME
 * @description
 */
public class TestThread extends Thread {
    public TestThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            for (long k = 0; k < 100000000; k++) {
            }
            System.out.println(this.getName() + " : " + i);
        }
    }

    public static void main(String[] args) {
        TestThread thread1 = new TestThread("李白");
        TestThread thread2 = new TestThread("杜甫");
        thread1.start();
        thread2.start();
    }
}
