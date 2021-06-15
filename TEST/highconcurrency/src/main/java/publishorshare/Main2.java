package publishorshare;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/23
 * @CLASSNAME
 * @description 对象逸出：当一个对象还没构造完成，就使它被其他线程所见。
 * this引用被线程t共享，故线程t的发布将导致Main对象的发布，
 * 由于Main2对象被发布时可能还未构造完成，
 * 这将导致Main2对象逸出（在构造函数中创建线程是可以的，
 * 但是不要在构造函数执行完之前启动线程）。
 */
public class Main2 {
    public Main2() {
        System.out.println(Main2.this);
        System.out.println(Thread.currentThread());
        System.out.println("================");
        Thread t = new Thread(InnerClass::new);
        t.start();
    }

    class InnerClass {
        public InnerClass() {
            System.out.println(Main2.this);
            System.out.println(Thread.currentThread());
            System.out.println("000000000000000");
        }
    }

    public static void main(String[] args) {
        new Main2();
    }
}
