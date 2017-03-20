package top.treegrowth.designmodel.observer.custom;

/**
 * @author wusi
 * @version 2017/3/20 9:22
 */
public class ConcreteObservable extends Observable {

    //自己的业务逻辑，做完之后通知观察者
    public void doSomething() {
        //处理自己的业务逻辑
        super.notifyObserver();
    }
}
