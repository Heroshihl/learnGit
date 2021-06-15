package factorymodel.abstractfactory.product;

import factorymodel.abstractfactory.Plant;

/**
 * @author shihl
 * @date 2020/8/31 17:35
 * @description 蔬菜
 */
public class Vegetables extends Plant {
    @Override
    public String showPlant() {
        String s = "我是一颗菜";
        System.out.println("我是一颗菜");
        return s;
    }
}
