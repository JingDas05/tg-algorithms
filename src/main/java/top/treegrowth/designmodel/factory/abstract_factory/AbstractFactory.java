package top.treegrowth.designmodel.factory.abstract_factory;

/**
 *
 * 抽象工厂，什么都能生产
 *
 * @author wusi
 * @version 2017/7/13 8:57
 */
public abstract class AbstractFactory {

    //生产A系列产品
    public abstract AbstractProductA createProductA();

    //生产B系列产品
    public abstract AbstractProductB createProductB();
}
