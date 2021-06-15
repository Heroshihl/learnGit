package factorymodel.factorymethod.factory;

import factorymodel.factorymethod.Computer;
import factorymodel.factorymethod.ComputerFactory;
import factorymodel.factorymethod.product.Disk;

/**
 * @author shihl
 * @date 2020/8/31 17:28
 * @description
 */
public class DiskFactory implements ComputerFactory {
    @Override
    public Computer getProduct() {
        return new Disk();
    }
}
