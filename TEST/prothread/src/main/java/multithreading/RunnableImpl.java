package multithreading;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/21
 * @CLASSNAME
 * @description
 */
public class RunnableImpl implements Runnable {

    private final String name;

    public RunnableImpl(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            //缓冲的一种方式
            for (long j = 0; j<100000000;j++){
            }
            System.out.println(name + " : " + i);
        }
    }
}
