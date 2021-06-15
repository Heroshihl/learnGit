package agent.staticagent;

import agent.Vendor;

/**
 * @author shihl
 * @date 2020/8/31 16:21
 * @description 测试商家代理
 */
public class TestBusinessProxy {
    public static void main(String[] args) {
//从厂家进货
        Vendor vendor = new Vendor();

//        商家出来谈
        BusinessAgent businessAgent = new BusinessAgent(vendor);

        businessAgent.sell();

        businessAgent.ad();
    }
}
