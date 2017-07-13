package top.treegrowth.designmodel.factory.abstract_factory;

/**
 * 生产2型号的产品，不分系列
 *
 * @author wusi
 * @version 2017/7/13 8:59
 */
public class Factory2 extends AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
