package top.treegrowth.designmodel.observer.java;

import java.util.Observer;

/**
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
