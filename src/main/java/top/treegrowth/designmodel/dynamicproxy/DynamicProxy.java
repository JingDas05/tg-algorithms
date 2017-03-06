package top.treegrowth.designmodel.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wusi
 * @version 2017/3/6 12:53
 */
public class DynamicProxy {

    //被代理的对象
    private Object target;
    //代理
    private Object proxy;

    public DynamicProxy(Object target) {
        this.target = target;
        Class targetClazz = target.getClass();
        this.proxy = Proxy.newProxyInstance(
                targetClazz.getClassLoader(),
                targetClazz.getInterfaces(),
                new MyInvokeHandler(target));
    }

    public Object exec(String methodName, Object... args) throws NoSuchMethodException {
        Object result = null;
        //参数为Class类型
        Class<?>[] paramTypes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            paramTypes[i] = args[i].getClass();
        }
        Method method = proxy.getClass().getMethod(methodName, paramTypes);
        try {
            result = method.invoke(this.proxy, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    //定义一个执行处理器，创建代理类时需要执行处理器
    class MyInvokeHandler implements InvocationHandler {

        private Object target;

        public MyInvokeHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result;
            before();
            //此处执行的是目标的方法
            result = method.invoke(target, args);
            after();
            return result;
        }

        //前置通知
        public void before() {
            System.out.println("执行before方法");
        }

        //后置通知
        public void after() {
            System.out.println("执行after方法");
        }
    }
}
