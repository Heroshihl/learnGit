package factorymodel.abstractfactory;

import factorymodel.abstractfactory.factory.SGfarm;
import factorymodel.abstractfactory.factory.SRfarm;

/**抽象工厂：工厂：接口，东西：抽象类
 * @author shihl
 * @date 2020/8/31 18:02
 * @description 要什么产品就去什么工厂买 ，该工厂不仅有这个产品  还有这一系列的产品
 * *如：办公电脑和办公鼠标属于一系列产品
 * 抽象工厂模式进一步扩展了工厂方法模式，它把原先的工厂方法模式中只能有一个抽象产品不能添加产品族的缺点克服了
 * 抽象工厂模式不仅仅遵循了OCP原则(对扩展开放，对修改关闭)，而且可以添加更多产品(抽象产品),
 * 具体工厂也不仅仅可以生成单一产品，而是生成一组产品，抽象工厂也是声明一组产品，对应扩展更加灵活，但是要是扩展族系就会很笨重。
 */
public class Test {
    public static void main(String[] args) {
        //看看韶关农场
        SGfarm SGfarm = new SGfarm();
        Animal sgAnimal = SGfarm.keepAnimal();
        Plant sgPlant = SGfarm.grownPlant();
        System.out.println("韶关农场:" + sgAnimal.showAnimal() + "--" + sgPlant.showPlant());

        //上饶农场
        SRfarm SRfarm = new SRfarm();
        Animal srAnimal = SRfarm.keepAnimal();
        Plant srPlant = SRfarm.grownPlant();
        System.out.println("上饶农场:" + srAnimal.showAnimal() + "--" + srPlant.showPlant());

    }
}
