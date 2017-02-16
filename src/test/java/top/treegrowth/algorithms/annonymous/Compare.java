package top.treegrowth.algorithms.annonymous;

/**
 * @FunctionalInterface 可以定义一个函数式接口，其他的方法需要写成default void test() {} 等；
* */
@FunctionalInterface
public interface Compare<T> {

    int compare(T v1, T v2);
    default void test() {};
}
