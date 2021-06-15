package factorymodel.factorymethod.factory;

import factorymodel.factorymethod.Computer;
import factorymodel.factorymethod.ComputerFactory;
import factorymodel.factorymethod.product.Displayer;

/**
 * @author shihl
 * @date 2020/8/31 17:29
 * @description
 */
public class DisplayerFactory implements ComputerFactory {
    @Override
    public Computer getProduct() {
        return new Displayer();
    }
}
