package top.treegrowth.designmodel.factory.abstract_factory;

/**
 *
 *
 * 单一职责原则
 * 依赖倒置原则
 * 接口隔离原则
 * 迪米特原则
 * 里氏替换原则
 * 开闭原则
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
