package staticinnerclass;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/21
 * @CLASSNAME
 * @description
 * 静态内部类：
 * 1、用static修饰的内部类，称为静态内部类，完全属于外部类本身，不属于外部类某一个对象
 * 2、static关键字的作用是把修饰的成员变成类相关，而不是实例相关
 * 3、静态内部类可以包含静态成员，也可以包含非静态成员，但是在非静态内部类中不可以声明静态成员。
 * 4、静态类内部不可以访问外部类的实例成员，只能访问外部类的类成员，即使是静态内部类的实例方法也不能访问外部类的实例成员，
 *   只能访问外部类的静态成员
 * 5、外部类不可以定义为静态类，Java中静态类只有一种，那就是静态内部类，顶级类不能用static 修饰
 * 6、外部类如何调用静态内部类中的属性和方法
 * 　　　1）外部类可以通过创建静态内部类实例的方法来调用静态内部类的非静态属性和方法
 * 　　　2）外部类可以直接通过“ 外部类.内部类.属性（方法）” 的方式直接调用静态内部类中的静态属性和方法
 * 7、如何创建静态内部类实例
 * 　　　1）在非外部类中：外部类名.内部类名 name = new 外部类名.内部类名();
 * 　　　2）在外部类中：内部类名 name = new 内部类名();
 */
public class StaticDome01 {
    //实例成员
    private int a = 10;
    //类成员
    private static int b = 20;

    static class StaticClass {
        public static int c = 30;
        public int d = 40;

        //类方法
        public static void print() {
            //下面代码会报错，静态内部类不能访问外部类实例成员
            //System.out.println(a);

            //静态内部类只可以访问外部类类成员
            System.out.println("静态内部类的静态方法，调用外部类类成员b");
            System.out.println("外部类类成员b=" + b);

        }

        private void Syso() {
            // TODO Auto-generated method stub

        }

        //实例方法
        public void print01() {
            //静态内部内所处的类中的方法，调用静态内部类的实例方法，属于外部类中调用静态内部类的实例方法
            System.out.println("静态内部类的实例方法，调用静态内部类的实例方法");
            StaticClass sc = new StaticClass();
            // 避免通过一个类的对象引用访问此类的静态变量或静态方法，无谓增加编译器解析成本，直接用类名来访问即可
            //sc.print();
            StaticClass.print();
        }

    }
}
