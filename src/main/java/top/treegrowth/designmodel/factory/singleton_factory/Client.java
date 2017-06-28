package top.treegrowth.designmodel.factory.singleton_factory;

/**
 * @author wusi
 * @version 2017/6/28 22:08.
 */
public class Client {

    public static void main(String[] args) {

        Singleton singleton = SingletonFactory.getInstance();
        singleton.method1();
    }
}
