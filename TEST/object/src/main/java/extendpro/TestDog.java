package extendpro;

import extendpro.son.Dog;

import java.util.Scanner;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/29
 * @CLASSNAME
 * @description
 */
public class TestDog {
    public static void main(String args[]){
        Animal a = new Animal(); // Animal 对象
        Animal b = new Dog(); // Dog 对象

        a.move();// 执行 Animal 类的方法
        b.move();//执行 Dog 类的方法
//        该程序将抛出一个编译错误，因为b的引用类型Animal没有bark方法。
   /**     b.bark();*/
        Dog dog = new Dog();
        dog.bark();//这才是可以的
        System.out.println("随便输入点什么");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入的是:");
        System.out.println(scanner.nextLine());
    }
}
