package agent.example2;

/**
 * @author shihl
 * @date 2020/8/31 16:50
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Man man = new Man();
        ManProxy manProxy = new ManProxy();
        ManProxy proxy = manProxy.setTarget(man);
        proxy.say();
    }
}
