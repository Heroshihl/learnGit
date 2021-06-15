package extendpro.son;

import extendpro.Animal;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/29
 * @CLASSNAME
 * @description
 */
public class Dog extends Animal {
    @Override
    public void move(){
        System.out.println("狗可以跑和走");
    }
    public void bark(){
        System.out.println("狗可以吠叫");
    }
}
