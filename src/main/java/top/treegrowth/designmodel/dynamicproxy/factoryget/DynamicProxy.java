package top.treegrowth.designmodel.dynamicproxy.factoryget;

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
        /**
         * 创建代理类
         * @param 类加载器，获取被代理对象的类加载器
         * @param 接口，获取被代理对象实现的方法
         * @param 代理处理器，代理类执行的时候执行的处理器
         * */
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
        //执行代理类的方法，包含了前置后置通知
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

    /**
     * 定义一个执行处理器，创建代理类时需要执行的处理器，
     * */
    class MyInvokeHandler implements InvocationHandler {

        private Object target;

        public MyInvokeHandler(Object target) {
            this.target = target;
        }

        /**
         * 定义一个执行处理器，创建代理类时需要执行的处理器，
         * @param proxy 此类是在 newProxyInstance中传入的，在newProxyInstance中传入的，此处不用传入（有些困惑）
         * @param method 这个方法是被代理的类的方法，在newProxyInstance中传入的，此处不用传入，只是执行（有些困惑）
         * @param args 这个参数是被代理的类的输入参数，这个地方是Object类型的，在newProxyInstance中传入的
         * */
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
