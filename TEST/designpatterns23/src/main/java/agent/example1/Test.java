package agent.example1;

import agent.example2.IPerson;

import java.lang.reflect.Proxy;

/**
 * @author shihl
 * @date 2020/8/31 16:59
 * @description
 */
public class Test {
    public static void main(String[] args) {
        AppServiceImpl appService = new AppServiceImpl();
        LoggerInterceptor loggerInterceptor = new LoggerInterceptor(appService);
//        获取代理实例
        AppService appService1 = (AppService) (Proxy.newProxyInstance(appService.getClass().getClassLoader(),appService.getClass().getInterfaces(),loggerInterceptor));
        appService1.createApp("shhl");
    }
}
