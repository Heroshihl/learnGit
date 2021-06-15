package factorymodel.factorymethod.product;

import factorymodel.factorymethod.Computer;

/**
 * @author shihl
 * @date 2020/8/31 17:27
 * @description
 */
public class Displayer implements Computer {
    @Override
    public void createComputer() {
        System.out.println("生产显卡displayer");
    }
}
