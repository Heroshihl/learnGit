package trysecond;

/**
 * @author shihl
 * @date 2020/9/10 17:03
 * @description 调用webservice服务
 *    国内手机号码归属地查询web服务
 *  这是别人写好的webservice服务，我来调用这个服务，但是我本地没有他的类怎么调用呢，
 *  于是下面就介绍怎样使用别人写好的webservice服务类
 *
 *   可以使用已有的服务，只要提供了WSDL文件，那么客户端就能导入这些服务，然后进行调用
 *   第一步、访问 http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?WSDL ，查看是否有WSDL文件
 *   第二步、实用工具得到客户端的方法：
 *   wsimport -keep -d E:\ideatest\TEST\socket\src\main\java -p trysecond http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?WSDL
 *   -keep 用于保留生成的类, 如果没有该指令会只生成class文件
 *   -d 后面接项目中存放这些工具类的包, 填绝对路径
 *   -p 填包名 + wdsl文档的地址
 *   第三步、在Test类中进行测试
 *
 *
 *   如何自定义webservice服务呢，详情查看  E:\ideatest\TEST\rpc\src\main\java\webservice包中的方法，
 *   主要使用  Endpoint.publish(address,new BossService());方这个法将服务发布上去，
 *   然后就可以使用wsimport这一套流程获取客户端实现远程方法调用
 *   特别注意 @Webservice 这个注解不能少，否则服务不能够发布到url上
 */
public class Test {
    public static void main(String[] args) {
        MobileCodeWS mobileCodeWS = new MobileCodeWS();
//        获取远程服务
        MobileCodeWSSoap soap = mobileCodeWS.getMobileCodeWSSoap();
//        调用服务的方法
        String info = soap.getMobileCodeInfo("15370811900", " ");
        System.out.println(info);
    }

}
