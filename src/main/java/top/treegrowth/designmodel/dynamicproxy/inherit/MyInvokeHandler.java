package top.treegrowth.designmodel.dynamicproxy.inherit;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wusi
 * @version 2017/3/8 9:04
 */
public class MyInvokeHandler implements InvocationHandler {

    private Object target;

    public MyInvokeHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
