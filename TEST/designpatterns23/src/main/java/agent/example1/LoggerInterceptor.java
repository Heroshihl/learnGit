package agent.example1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author shihl
 * @date 2020/8/31 16:38
 * @description  日志处理器（实质充当了动态代理类）
 */
public class LoggerInterceptor implements InvocationHandler {
    private Object target;//目标对象的引用，这里设计成Object类型，更具通用性
    public LoggerInterceptor(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Entered "+target.getClass().getName()+"-"+method.getName()+",with arguments{"+args[0]+"}");
        Object result = method.invoke(target, args);//调用目标对象的方法
        System.out.println("Before return:"+result);
        return result;
    }
}
