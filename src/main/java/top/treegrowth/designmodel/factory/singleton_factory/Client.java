package top.treegrowth.designmodel.factory.singleton_factory;

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
 * @version 2017/6/28 22:08.
 */
public class Client {

    public static void main(String[] args) {

        Singleton singleton = SingletonFactory.getInstance();
        singleton.method1();
    }
}
