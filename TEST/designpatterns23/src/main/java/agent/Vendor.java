package agent;

/**
 * @author shihl
 * @date 2020/8/31 16:14
 * @description  生产厂家
 */
public class Vendor implements Sell {
    @Override
    public void sell() {
        System.out.println("厂家直销");
    }

    @Override
    public void ad() {
        System.out.println("新品上市");
    }
}
