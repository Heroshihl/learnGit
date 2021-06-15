package threadsync;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/21
 * @CLASSNAME
 * @description
 */
public class FooRunnable implements Runnable {
    private Foo foo = new Foo();

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            foo.fix(30);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " :当前foo对象的x值= " + foo.getX());
        }
    }
}
