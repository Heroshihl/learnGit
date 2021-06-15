package socket;

import java.io.IOException;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/30
 * @CLASSNAME
 * @description
 */
public class Test {
    public static void main(String[] args) {
        int port = 8888;
        try {
            Thread t = new GreetingServer(port);
            t.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
