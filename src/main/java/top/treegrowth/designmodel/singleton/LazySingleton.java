package top.treegrowth.designmodel.singleton;

/**
 * @author wusi
 * @version 2017/6/27 8:55
 */
public class LazySingleton {

    private static LazySingleton singleton;

    private LazySingleton() {
    }

    // 懒加载，如果为空再赋值
    public synchronized LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

    // 自己的方法
    public static String doSomeThing() {
        return null;
    }
}
