package top.treegrowth.designmodel.dynamicproxy.inherit;

/**
 * @author wusi
 * @version 2017/3/8 9:20
 */
public class Client {

    public static void main(String[] args) {
        ISubject subject = new ConcreteSubject();
        //泛型咋用的？
        ISubject proxySubject = SubjectDynamicProxy.newProxyInstance(subject);
        proxySubject.doSomething("蒙了");
    }
}
