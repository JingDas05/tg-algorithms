package top.treegrowth.java.bridgemethod;

/**
 * 测试java桥接方法 反射method isBridge()来判断
 * 桥接方法是 JDK 1.5 引入泛型后，为了使Java的泛型方法生成的字节码和 1.5 版本前的字节码相兼容，由编译器自动生成的方法
 * @author wusi
 * @version 2017/6/12 7:19.
 */
public interface SuperInterface<T> {
    T method(T param);
}
