package top.treegrowth.java.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理处理器
 *
 * @author wusi
 * @version 2019/1/10 22:40.
 */
public class CommonExpressHandler implements InvocationHandler {

    private Express express;

    public CommonExpressHandler(Express express) {
        this.express = express;
    }

    // proxy-是要代理的对象的引用
    // method-要执行的方法
    // args-方法参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = method.invoke(express, args);
        System.out.println("after");
        return invoke;
    }
}
