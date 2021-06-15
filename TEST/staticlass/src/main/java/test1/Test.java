package test1;

/**
 * @author shihl
 * @version SDT4.0-1400
 * @description
 * @date 2021/1/5
 */
public class Test {
    Person person = new Person("Test");
    static{
        System.out.println("test static");
    }

    public Test() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new MyClass();
    }
}
