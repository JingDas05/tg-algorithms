package top.treegrowth.java.extend;

/**
 * @author wusi
 * @version 2018/4/26 8:14.
 */
public interface Person {

    default String getName(){
        return getClass().getName();
    };
}
