package test2;

/**
 * @author shihl
 * @version SDT4.0-1400
 * @description
 * @date 2021/1/5
 */
public class Test extends Base{
    static{
        System.out.println("test static");
    }

    public Test(){
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new Test();
    }
}
