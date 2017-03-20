package top.treegrowth.designmodel.observer.custom;

/**
 *
 *观察者1
 *
 * @author wusi
 * @version 2017/3/20 9:25
 */
public class ConcreteObserver1 implements Observer{

    //这个具体实现了观察者的update, 这个方法可以入参被观察者的参数
    @Override
    public void update() {
        System.out.println("观察者接收到信息了");
    }
}
