package factorymodel.simplefactory.product;

import factorymodel.simplefactory.Car;

/**
 * @author shihl
 * @date 2020/8/31 17:41
 * @description
 */
public class BenChiCar implements Car {
    @Override
    public void myCar() {
        System.out.println("我有一辆奔驰车！");
    }
}
