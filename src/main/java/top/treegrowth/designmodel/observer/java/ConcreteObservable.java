package top.treegrowth.designmodel.observer.java;

import java.util.Observable;

/**
 * @author wusi
 * @version 2017/3/22 9:05
 */
public class ConcreteObservable extends Observable {

    public void doSomething() {
        System.out.println("被观察者做事情了");
        setChanged();
        notifyObservers("通知的时候传入的信息");
    }
}
