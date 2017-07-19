package top.treegrowth.designmodel.factory.simple_factory;

/**
 *
 * 单一职责原则
 * 依赖倒置原则
 * 接口隔离原则
 * 迪米特原则
 * 里氏替换原则
 * 开闭原则
 *
 * @author wusi
 * @version 2017/6/27 14:06
 */
public class Client {

    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product1 =  creator.createProduct(ConcreteProduct1.class);
        product1.method1();
        product1.method2();
        Product product2 =  creator.createProduct(ConcreteProduct2.class);
        product2.method1();
        product2.method2();
    }
}
