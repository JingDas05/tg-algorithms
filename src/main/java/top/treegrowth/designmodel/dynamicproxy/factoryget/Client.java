package top.treegrowth.designmodel.dynamicproxy.factoryget;

/**
 * @author wusi
 * @version 2017/3/6 13:10
 */
public class Client {
    public static void main(String[] args) {
        Object result = null;
        ISubject subject = new ConcreteSubject();
        DynamicProxy dynamicProxy = new DynamicProxy(subject);
        String[] stringParam = {"1111"};
        try {
            result = dynamicProxy.exec("doSomething", stringParam);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
