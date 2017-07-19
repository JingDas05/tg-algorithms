package top.treegrowth.designmodel.observer.custom;

/**
 *
 *
 * 单一职责原则
 * 依赖倒置原则
 * 接口隔离原则
 * 迪米特原则
 * 里氏替换原则
 * 开闭原则
 *
 * @author wusi
 * @version 2017/3/20 9:37
 */
public class Client {

    //初始化被观察者
    private static ConcreteObservable observable = new ConcreteObservable();
    //初始化观察者
    private static Observer observer = new ConcreteObserver1();

    public static void main(String[] args) {
        observable.addObserver(observer);
        observable.doSomething();
    }

}
