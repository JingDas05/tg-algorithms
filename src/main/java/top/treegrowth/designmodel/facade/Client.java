package top.treegrowth.designmodel.facade;

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
 * @version 2017/3/11 20:47.
 */
public class Client {

    static Facade1 facade1 = new Facade1();
    static Facade2 facade2 = new Facade2();

    public static void main(String[] args) {
        facade1.methodB();
        facade2.methodB();
        facade2.methodCWithContext();
    }
}
