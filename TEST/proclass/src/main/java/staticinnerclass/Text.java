package staticinnerclass;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/21
 * @CLASSNAME
 * @description
 */
public class Text {
    public static void main(String[] args) {
        /**
         * 要想访问静态内部类的实例成员，需先创建实例对象，才可以调用，
         * 因为实例成员是属于实例的， 创建方法：外部类名.内部类名 name = new
         * 外部类名.内部类名()
         * 通过“ 外部类.内部类.属性（方法）” 的方式直接调用静态内部类中的静态属性和方法
         */
        StaticDome01.StaticClass st = new StaticDome01.StaticClass();
        //访问静态内部类的实例方法
        st.print01();
        //访问静态内部类的实例成员
        int i = st.d;
        System.out.println("非外部类调用静态内部类的实例成员d = "+i);
        //访问静态内部类的类成员
        int j = StaticDome01.StaticClass.c;
        System.out.println("非外部类调用静态内部类的类成员C = "+j);
        //访问静态内部类的类方法
        System.out.println("访问静态内部类的类方法：");
        StaticDome01.StaticClass.print();
    }
}
