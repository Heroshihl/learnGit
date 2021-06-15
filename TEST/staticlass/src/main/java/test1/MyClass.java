package test1;

/**
 * @author shihl
 * @version SDT4.0-1400
 * @description
 * @date 2021/1/5
 */
public class MyClass extends Test{
    Person person = new Person("MyClass");
    static{
        System.out.println("myclass static");
    }

    public MyClass() {
        System.out.println("myclass constructor");
    }
}
