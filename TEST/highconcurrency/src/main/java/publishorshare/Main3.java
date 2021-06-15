package publishorshare;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/23
 * @CLASSNAME
 * @description 通过私有构造函数 + 工厂模式解决。
 */
public class Main3 {
    private Thread t;

    private Main3() {
        System.out.println(Main3.this);
        System.out.println(Thread.currentThread());
        System.out.println("===================");
        this.t = new Thread(InnerClass::new);
    }

    class InnerClass {
        public InnerClass() {
            System.out.println(Main3.this);
            System.out.println(Thread.currentThread());
            System.out.println("---1111111");
        }
    }

    public static Main3 getMainInstance() {
        Main3 main = new Main3();
        main.t.start();
        return main;
    }

    public static void main(String[] args) {
        getMainInstance();
    }
}
