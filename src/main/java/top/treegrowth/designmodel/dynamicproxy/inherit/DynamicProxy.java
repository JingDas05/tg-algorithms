package top.treegrowth.designmodel.dynamicproxy.inherit;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author wusi
 * @version 2017/3/8 9:06
 */
public class DynamicProxy {

    public static  <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) {

        //在创建代理对象之前执行前置通知，这个和上面的 factoryget 还不太一样，上面的是在invocationHandler中执行
        if (true) {
            new BeforeAdvice().exec();
        }
        // 这个地方用了一个强制类型转换
        return (T) Proxy.newProxyInstance(loader, interfaces, h);
    }
}
