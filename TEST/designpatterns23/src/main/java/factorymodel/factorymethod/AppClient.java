package factorymodel.factorymethod;

import factorymodel.factorymethod.factory.CpuFactory;
import factorymodel.factorymethod.factory.DiskFactory;
import factorymodel.factorymethod.factory.DisplayerFactory;

/**工厂方法： 工厂：接口  东西 接口
 * @author shihl
 * @date 2020/8/31 17:29
 * @description 工厂方法 产品和工厂都是接口  A工厂只能生产A产品  B工厂只能生产B产品
 * 工厂方法模式是简单工厂的扩展，工厂方法模式把原先简单工厂中的实现那个类的逻辑判断交给了客户端，
 * 如像添加功能只需要修改客户和添加具体的功能，不用去修改之前的类。
 *
 * 要什么产品就必须去哪个工厂买，工厂特定！
 */
public class AppClient {
    public static void main(String[] args) {
        ComputerFactory computerFactory = new CpuFactory();
        computerFactory.getProduct().createComputer();

        System.out.println("---------------------------- ");

        computerFactory = new DiskFactory();
        computerFactory.getProduct().createComputer();

        System.out.println("---------------------------- ");

        computerFactory = new DisplayerFactory();
        computerFactory.getProduct().createComputer();

    }
}
