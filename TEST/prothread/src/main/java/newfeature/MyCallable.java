package newfeature;

import java.util.concurrent.Callable;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/22
 * @CLASSNAME
 * @description
 */
public class MyCallable implements Callable {
    private String oid;

    MyCallable(String oid) {
        this.oid = oid;
    }

    @Override
    public Object call() throws Exception {
        return oid + "任务返回的内容";
    }
}
