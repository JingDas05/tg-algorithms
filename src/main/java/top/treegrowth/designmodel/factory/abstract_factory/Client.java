package top.treegrowth.designmodel.factory.abstract_factory;

/**
 *
 * 抽象工厂客户端
 *
 * @author wusi
 * @version 2017/7/13 9:00
 */
public class Client {

    public static void main(String[] args) {
        AbstractFactory factory1 = new Factory1();
        AbstractFactory factory2 = new Factory2();
        factory1.createProductA().doSomething();
        factory1.createProductB().doSomething();
        factory2.createProductB().doSomething();
        factory2.createProductA().doSomething();
        // 结果
//        产品A1的方法
//        产品B1的方法
//        产品B2的方法
//        产品A2的方法
    }
}
