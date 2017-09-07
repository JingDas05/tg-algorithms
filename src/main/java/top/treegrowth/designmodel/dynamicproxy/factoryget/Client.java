package top.treegrowth.designmodel.dynamicproxy.factoryget;

/**
 * 动态代理模式
 * <p>
 * 单一职责原则
 * 依赖倒置原则
 * 接口隔离原则
 * 迪米特原则
 * 里氏替换原则
 * 开闭原则
 *
 * @author wusi
 * @version 2017/3/6 13:10
 */
public class Client {
    public static void main(String[] args) {
        Object result = null;
        ISubject subject = new ConcreteSubject();
        DynamicProxy dynamicProxy = new DynamicProxy(subject);
        // 第一种执行方法
        String[] stringParam = {"1111"};
        try {
            result = dynamicProxy.exec("doSomething", stringParam);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("========================="+"华丽的分割线"+"============================");
        // 第二种执行方法,获取代理object强转
        ISubject subject2 = new ConcreteSubject();
        ISubject forceDynamicProxy = (ISubject) new DynamicProxy(subject2).getProxy();
        forceDynamicProxy.doSomething("2222");
    }
}
