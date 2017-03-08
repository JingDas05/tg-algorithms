package top.treegrowth.designmodel.dynamicproxy.inherit;

import java.lang.reflect.InvocationHandler;

/**
 * @author wusi
 * @version 2017/3/8 9:11
 */
public class SubjectDynamicProxy extends DynamicProxy {

    public static<T> T newProxyInstance(ISubject subject) {
        ClassLoader classLoader = subject.getClass().getClassLoader();
        Class[] classes = subject.getClass().getInterfaces();
        InvocationHandler myInvocationHandler = new MyInvokeHandler(subject);
        return newProxyInstance(classLoader, classes, myInvocationHandler);
    }
}
