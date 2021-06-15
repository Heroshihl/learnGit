package agent;

/**
 * @author shihl
 * @date 2020/8/31 15:29
 * @description 目标对象 委托类  爷爷家的茶叶
 */
public class BlogService implements IBlogService {
    @Override
    public void writeBlog() {
        System.out.println("爷爷家的好茶，都是刚采摘的新鲜货");
    }
}

