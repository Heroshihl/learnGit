package agent.example1;

import java.lang.reflect.Proxy;

/**
 * @author shihl
 * @date 2020/8/31 16:41
 * @description
 */
public class Main {
    public static void main(String[] args) {
        AppService target = new AppServiceImpl();//生成目标对象
        //接下来创建代理对象
        AppService proxy = (AppService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new LoggerInterceptor(target));
        proxy.createApp("Kevin Test");

    }
}
