package agent.example2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author shihl
 * @date 2020/8/31 16:46
 * @description 静态代理
 */
public class ManProxy implements IPerson {
    private IPerson target;

    public IPerson getTarget() {
        return target;
    }

    public ManProxy setTarget(IPerson target) {
        this.target = target;
        return this;
    }

    @Override
    public void say() {
        if (target != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
            sdf.applyPattern("yyyy年MM月dd日 HH时mm分ss秒");
            System.out.println("静态代理说话了：" +  sdf.format(System.currentTimeMillis()));
            target.say();
        }
    }
}
