package top.treegrowth.java.extend;

/**
 * @author wusi
 * @version 2018/4/26 8:13.
 */
public interface Named {

    default String getName() {
        return getClass().getName() + "_" +  hashCode();
    }
}
