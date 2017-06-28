package top.treegrowth.designmodel.factory.singleton_factory;

import java.lang.reflect.Constructor;

/**
 * @author wusi
 * @version 2017/6/28 22:08.
 */
public class SingletonFactory {

    private static Singleton singleton;

    static {
        try {
            Class clazz = Class.forName(Singleton.class.getName());
            Constructor constructor =  clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            singleton = (Singleton) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
