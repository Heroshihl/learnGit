package agent.staticagent;

import agent.IBlogService;

/**
 * @author shihl
 * @date 2020/8/31 15:35
 * @description 静态代理  直播带货
 */
public class BlogStaticProxy implements IBlogService {
//    给爷爷 做代理，卖他家的茶叶
    private IBlogService blogService;
//构造方法 ，给爷爷家代理
    public BlogStaticProxy(IBlogService blogService) {
        this.blogService = blogService;
    }
    @Override
    public void writeBlog() {
//自己的方法
        System.out.println("网红：我先打个头，接下是爷爷介绍");
//带货
        blogService.writeBlog();
//        直播结束
        System.out.println("好心人都买光了");
    }
}
