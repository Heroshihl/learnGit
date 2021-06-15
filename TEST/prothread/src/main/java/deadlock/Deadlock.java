package deadlock;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/21
 * @CLASSNAME
 * @description 假设read()方法由一个线程启动，write()方法由另外一个线程启动。
 * 读线程将拥有resourceA锁，写线程将拥有resourceB锁，两者都坚持等待的话就出现死锁。
 * 实际上，上面这个例子发生死锁的概率很小。因为在代码内的某个点，CPU必须从读线程切换到写线程，
 * 所以，死锁基本上不能发生。
 * 但是，无论代码中发生死锁的概率有多小，一旦发生死锁，程序就死掉。有一些设计方法能帮助避免死锁，
 * 包括始终按照预定义的顺序获取锁这一策略。已经超出SCJP的考试范围。
 */
public class Deadlock {
    private static class Resource {
        public int value;
    }

    private Resource resourceA = new Resource();
    private Resource resourceB = new Resource();

    public int read() {
        synchronized (resourceA) {
            synchronized (resourceB) {
                return resourceB.value + resourceA.value;
            }
        }
    }

    public void write(int a, int b) {
        synchronized (resourceB) {
            synchronized (resourceA) {
                resourceA.value = a;
                resourceB.value = b;
            }
        }
    }
}
