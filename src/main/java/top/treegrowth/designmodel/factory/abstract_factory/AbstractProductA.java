package top.treegrowth.designmodel.factory.abstract_factory;

/**
 * @author wusi
 * @version 2017/7/13 8:50
 */
public abstract class AbstractProductA {

    //每个产品共有的方法
    public void shareMethod() {
        System.out.println("产品A共有方法");
    }

    //每个产品相同方法，需要子类不同的实现
    public abstract void doSomething();
}
