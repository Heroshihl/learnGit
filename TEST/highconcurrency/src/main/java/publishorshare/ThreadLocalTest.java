package publishorshare;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/23
 * @CLASSNAME
 * @description 尽管是从在同一个对象中的同一个成员变量取值，也会因为线程不同的原因取到不同的值，
 * 因为set的时候ThreadLocal会根据线程来设置进对应的map中。
 */
public class ThreadLocalTest {
    private ThreadLocal<String> localString = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadLocalTest t = new ThreadLocalTest();
        Runnable runnable = () -> {
            t.localString.set("localString in thread: " + Thread.currentThread());
            System.out.println(t.localString.get());
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
