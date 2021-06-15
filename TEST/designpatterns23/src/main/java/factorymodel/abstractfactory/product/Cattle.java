package factorymodel.abstractfactory.product;

import factorymodel.abstractfactory.Animal;

/**
 * @author shihl
 * @date 2020/8/31 17:33
 * @description 牛
 */
public class Cattle extends Animal {
    @Override
    public String showAnimal() {
        String s = "我是一头牛";
        System.out.println(s);
        return s;
    }
}
