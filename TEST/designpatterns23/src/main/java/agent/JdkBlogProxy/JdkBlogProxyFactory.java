package agent.JdkBlogProxy;

import java.lang.reflect.Proxy;

/**
 * @author shihl
 * @date 2020/8/31 16:01
 * @description jdk的动态代理
 */
public class JdkBlogProxyFactory {
    private Object target;

    public JdkBlogProxyFactory(Object target) {
        this.target = target;
    }

    public Object newInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("网红请不起，jdk来帮忙");
                    Object o = method.invoke(target, args);
                    System.out.println("jdk小伙子卖完了");
                    return o;
                });
    }
}
