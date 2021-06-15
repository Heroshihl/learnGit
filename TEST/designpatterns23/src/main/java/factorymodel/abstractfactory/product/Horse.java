package factorymodel.abstractfactory.product;

import factorymodel.abstractfactory.Animal;

/**
 * @author shihl
 * @date 2020/8/31 17:34
 * @description 马🐎
 */
public class Horse extends Animal {
    @Override
    public String showAnimal() {
        String s = "我是一匹马";
        System.out.println(s);
        return s;
    }
}
