package top.treegrowth.designmodel.factory.simple_factory;

/**
 * @author wusi
 * @version 2017/6/27 13:59
 */
public class ConcreteProduct2 extends Product{
    @Override
    public void method2() {
        // 覆写抽象类的方法，实现自己的逻辑
        System.out.println("产品2");
    }
}
