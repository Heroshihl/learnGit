package agent.staticagent;

import agent.Sell;

/**
 * @author shihl
 * @date 2020/8/31 16:16
 * @description 商家代理
 */
public class BusinessAgent implements Sell {
    //从厂家进货
    private Sell vendor;

    public BusinessAgent(Sell vendor) {
        this.vendor = vendor;
    }

    @Override
    public void sell() {
        System.out.println("我是商家,我带货");
        vendor.sell();
    }

    @Override
    public void ad() {
        vendor.ad();
    }
}
