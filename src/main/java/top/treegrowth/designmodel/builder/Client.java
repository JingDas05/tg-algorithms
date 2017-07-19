package top.treegrowth.designmodel.builder;

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
 * @version 2017/7/15 14:55
 */
public class Client {

    public static void main(String[] args) {
        Director director = new Director();
        director.getProduct().doSomething();
    }
}
