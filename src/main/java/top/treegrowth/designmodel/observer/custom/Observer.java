package top.treegrowth.designmodel.observer.custom;

/**
 * 观察者
 *
 * @author wusi
 * @version 2017/3/20 9:13
 */
public interface Observer {

    //当被观察者发生变化时，更新观察者
    void update();
}
