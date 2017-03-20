package top.treegrowth.designmodel.observer.custom;

/**
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
