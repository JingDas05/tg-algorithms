package top.treegrowth.designmodel.observer.java;

import java.util.Observer;

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
 * @version 2017/3/22 9:16
 */
public class Client {

    //观察者
    private static Observer observer = new ConcreteObserver();
    //被观察者
    private static ConcreteObservable observable = new ConcreteObservable();

    public static void main(String[] args) {
        //被观察的人添加观察者
        observable.addObserver(observer);
        observable.doSomething();
    }
}
