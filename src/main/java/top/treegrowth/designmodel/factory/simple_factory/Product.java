package top.treegrowth.designmodel.factory.simple_factory;

/**
 * @author wusi
 * @version 2017/6/27 13:57
 */
public abstract class Product {

    // 产品类的公共方法
    public void method1() {
        // 业务逻辑
        System.out.println("父产品");
    }

    //抽象方法，允许子类有不同的实现
    public abstract void method2();
}
