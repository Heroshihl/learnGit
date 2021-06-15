package agent.staticagent;

import agent.BlogService;
import agent.staticagent.BlogStaticProxy;

/**
 * @author shihl
 * @date 2020/8/31 15:40
 * @description 测试这个静态方法
 */
public class TestStaticProxy {
    public static void main(String[] args) {
//        拿出爷爷家的茶叶
        BlogService blogService = new BlogService();
//        网红介绍
        BlogStaticProxy proxy = new BlogStaticProxy(blogService);
//        网红叫卖
        proxy.writeBlog();
    }
}
