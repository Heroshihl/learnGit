package factorymodel.abstractfactory.product;

import factorymodel.abstractfactory.Plant;

/**
 * @author shihl
 * @date 2020/8/31 17:35
 * @description 水果
 */
public class Fruitage extends Plant {
    @Override
    public String showPlant() {
        String s = "我是水果";
        System.out.println("我是水果");
        return s;
    }
}
