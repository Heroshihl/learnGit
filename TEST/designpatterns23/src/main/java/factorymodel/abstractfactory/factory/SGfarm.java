package factorymodel.abstractfactory.factory;

import factorymodel.abstractfactory.Animal;
import factorymodel.abstractfactory.Farm;
import factorymodel.abstractfactory.Plant;
import factorymodel.abstractfactory.product.Vegetables;
import factorymodel.abstractfactory.product.Cattle;

/**
 * @author shihl
 * @date 2020/8/31 17:37
 * @description 韶关农场
 */
public class SGfarm implements Farm {

    /**
     * @return 养牛
     */
    @Override
    public Animal keepAnimal() {
        return new Cattle();
    }

    /**
     * @return 种蔬菜
     */
    @Override
    public Plant grownPlant() {
        return new Vegetables();
    }
}
