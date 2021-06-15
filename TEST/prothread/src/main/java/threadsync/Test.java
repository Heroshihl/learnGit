package threadsync;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/21
 * @CLASSNAME
 * @description 线程的同步是为了防止多个线程访问一个数据对象时，对数据造成的破坏。
 *
 *         例如：两个线程ThreadA、ThreadB都操作同一个对象Foo对象，并修改Foo对象上的数据。
 */
public class Test {
    public static void main(String[] args) {
        FooRunnable r = new FooRunnable();
        Thread tA = new Thread(r, "Thread-A");
        Thread tB = new Thread(r, "Thread-B");
        tA.start();
        tB.start();
    }
}
