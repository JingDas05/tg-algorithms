package top.treegrowth.designmodel.singleton;

/**
 * @author wusi
 * @version 2017/6/27 7:48.
 */
public class Singleton {

    private static final Singleton singleton = new Singleton();

    // 私有构造方法，禁止new
    private Singleton(){}

    // 获取单例的实例
    public static Singleton getInstance() {
        return singleton;
    }

    // 单例模式中的方法，尽量是static的
    public String doSomeThing() {
        return null;
    }
}
