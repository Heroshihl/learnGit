package factorymodel.abstractfactory.factory;

import factorymodel.abstractfactory.Animal;
import factorymodel.abstractfactory.Farm;
import factorymodel.abstractfactory.Plant;
import factorymodel.abstractfactory.product.Fruitage;
import factorymodel.abstractfactory.product.Horse;

/**
 * @author shihl
 * @date 2020/8/31 17:38
 * @description 上饶农场
 */
public class SRfarm implements Farm {
    /**
     * @return 养马
     */
    @Override
    public Animal keepAnimal() {
        return new Horse();
    }

    /**
     * @return 种水果
     */
    @Override
    public Plant grownPlant() {
        return new Fruitage();
    }
}
