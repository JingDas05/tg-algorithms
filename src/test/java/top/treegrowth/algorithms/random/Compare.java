package top.treegrowth.algorithms.random;

@FunctionalInterface
public interface Compare<T> {

    boolean process(T t);

}
