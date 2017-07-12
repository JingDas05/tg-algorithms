package top.treegrowth.designmodel.bridge;

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
 * @version 2017/2/23 13:52
 */
public class Client {


    public static void main(String[] args) {
        Implement a = new ConcreteImplA();
        Abstract anAbstract = new RefinedAbstract(a);
        anAbstract.request();
    }
}
