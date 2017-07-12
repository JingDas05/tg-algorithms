package top.treegrowth.designmodel.dynamicproxy.inherit;

/**
 *
 * 单一职责原则
 * 依赖倒置原则
 * 接口隔离原则
 * 迪米特原则
 * 里氏替换原则
 * 开闭原则
 *
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
