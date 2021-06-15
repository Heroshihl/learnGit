package test1;

/**
 * @author shihl
 * @version SDT4.0-1400
 * @description
 * @date 2021/1/5
 */
public class Person {
    static{
        System.out.println("person static");
    }
    public Person(String str) {
        System.out.println("person "+str);
    }
}
