package factorymodel.simplefactory.product;

import factorymodel.simplefactory.Car;

/**
 * @author shihl
 * @date 2020/8/31 17:42
 * @description
 */
public class LamborghiniCar implements Car {
    @Override
    public void myCar() {
        System.out.println("我有一辆兰博基尼！");
    }
}
