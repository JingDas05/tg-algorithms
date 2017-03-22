package top.treegrowth.designmodel.observer.java;

import java.util.Observable;
import java.util.Observer;

/**
 * @author wusi
 * @version 2017/3/22 9:10
 */
public class ConcreteObserver implements Observer {

    //o 为观察对象，arg 为通知的时候传入的参数（可以为空）
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("通知的时候传入的信息：" + arg.toString());
    }
}
