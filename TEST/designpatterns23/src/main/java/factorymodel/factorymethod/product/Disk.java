package factorymodel.factorymethod.product;

import factorymodel.factorymethod.Computer;

/**
 * @author shihl
 * @date 2020/8/31 17:26
 * @description
 */
public class Disk implements Computer {
    @Override
    public void createComputer() {
        System.out.println("生产磁盘disk");
    }
}
