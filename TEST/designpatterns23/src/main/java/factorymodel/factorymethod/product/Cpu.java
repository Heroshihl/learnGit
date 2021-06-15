package factorymodel.factorymethod.product;

import factorymodel.factorymethod.Computer;

/**
 * @author shihl
 * @date 2020/8/31 17:23
 * @description
 */
public class Cpu implements Computer {
    @Override
    public void createComputer() {
        System.out.println("生产cpu");
    }
}
