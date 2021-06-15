package factorymodel.simplefactory;

/**简单工厂 ：工厂：类  东西：接口
 * @author shihl
 * @date 2020/8/31 17:43
 * @description 简单工厂：产品是接口 工厂是类  要哪个产品就生产哪一个
 * 简单工厂模式最大的优点就是工厂内有具体的逻辑去判断生成什么产品，
 * 将类的实例化交给了工厂，这样当我们需要什么产品只需要修改客户端的调用而不需要去修改工厂，
 * 对于客户端来说降低了与具体产品的依赖
 *
 * 不管是什么工厂，我只管去要产品
 */
public class Test {
    public static void main(String[] args) {
        Car car = CarFactory.createCar("BenChiCar");
        car.myCar();

        Car car2 = CarFactory.createCar("FerrariCar");
        car2.myCar();
    }
}
