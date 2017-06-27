package top.treegrowth.designmodel.singleton;

/**
 * @author wusi
 * @version 2017/6/27 9:27
 */
public class LazySingletonVolatile {

    // volatile 关键词确保， 当singletonVolatile变量被初始化成LazySingletonVolatile
    // 实例的时候，多个线程正确地处理singletonVolatile变量
    // 注意:在java1.4及更早版本中，许多jvm对于volatile关键字的实现会导致双重检查加锁的失效
    private volatile static LazySingletonVolatile singletonVolatile;

    public static LazySingletonVolatile getInstance() {
        if (singletonVolatile == null) {
            synchronized (LazySingletonVolatile.class) {
                if (singletonVolatile == null) {
                    singletonVolatile = new LazySingletonVolatile();
                }
            }
        }
        return singletonVolatile;
    }
}
