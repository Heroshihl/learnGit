package factorymodel.simplefactory;

import factorymodel.simplefactory.product.BenChiCar;
import factorymodel.simplefactory.product.FerrariCar;
import factorymodel.simplefactory.product.LamborghiniCar;

/**
 * @author shihl
 * @date 2020/8/31 17:42
 * @description
 */
public class CarFactory {
    public static Car createCar(String carName) {
        if (carName == null) {
            return null;
        }
        switch (carName) {
            case "BenChiCar":
                return new BenChiCar();
            case "FerrariCar":
                return new FerrariCar();
            case "LamborghiniCar":
                return new LamborghiniCar();
            default:
                return null;
        }
    }
}
