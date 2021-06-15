package agent.JdkBlogProxy;

import agent.BlogService;
import agent.IBlogService;

/**
 * @author shihl
 * @date 2020/8/31 16:03
 * @description jdk动态代理的测试
 */
public class TestJdkProxy {
    public static void main(String[] args) {
//        还是得先把爷爷请过来
        IBlogService target = new BlogService();
        System.out.println(target.getClass());
//        然后jdk小伙子上
        // 给目标对象，创建代理对象
        IBlogService proxy = (IBlogService) new JdkBlogProxyFactory(target).newInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        // 执行方法   【代理对象】
        proxy.writeBlog();
    }
}
