package top.treegrowth.designmodel.factory.simple_factory;

/**
 * @author wusi
 * @version 2017/6/27 14:00
 */
public abstract class Creator {

    // 创建产品的抽象类方法，输入的参数通常为String、Enum、Class等，当然也可以为空
    public abstract <T extends Product> T createProduct(Class<T> clazz);
}
