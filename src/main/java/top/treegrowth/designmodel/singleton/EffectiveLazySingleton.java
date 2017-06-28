package top.treegrowth.designmodel.singleton;

/**
 *
 * 由于实例的建立是在类加载时完成，故天生对于多线程友好，
 * 而且效率高于 LazySingleton 和 LazySingletonVolatile
 *
 * @author wusi
 * @version 2017/6/28 22:47.
 */
public class EffectiveLazySingleton {

    private EffectiveLazySingleton() {
        System.out.println("单例初始化了");
    }

    private static class SingletonHolder {
        private static EffectiveLazySingleton singleton = new EffectiveLazySingleton();
    }

    public static EffectiveLazySingleton getInstance() {
        return SingletonHolder.singleton;
    }
}
