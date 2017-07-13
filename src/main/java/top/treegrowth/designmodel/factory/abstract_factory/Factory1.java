package top.treegrowth.designmodel.factory.abstract_factory;

/**
 * 生产1型号的产品，不分系列
 *
 * @author wusi
 * @version 2017/7/13 8:58
 */
public class Factory1 extends AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
