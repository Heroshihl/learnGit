package factorymodel.abstractfactory;

/**
 * @author shihl
 * @date 2020/8/31 17:36
 * @description  农场养动物种植物
 */
public interface Farm {
    /**
     * 养动物
     * @return
     */
    Animal keepAnimal();

    /**
     * 种植物
     * @return
     */
    Plant grownPlant();
}
