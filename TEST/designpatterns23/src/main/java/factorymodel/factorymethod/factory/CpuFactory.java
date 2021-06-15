package factorymodel.factorymethod.factory;

import factorymodel.factorymethod.Computer;
import factorymodel.factorymethod.ComputerFactory;
import factorymodel.factorymethod.product.Cpu;

/**
 * @author shihl
 * @date 2020/8/31 17:28
 * @description
 */
public class CpuFactory implements ComputerFactory {
    @Override
    public Computer getProduct() {
        return new Cpu();
    }
}
