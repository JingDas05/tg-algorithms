package top.treegrowth.algorithms.common;

import java.io.Serializable;

/**
 * @author wusi
 * @version 20170212
 */
public class Utils implements Serializable{

    public static void exchange(Object[] source, int i, int j) {
        Object temp = source[i];
        source[i] = source[j];
        source[j] = temp;
    }

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    public static boolean more(Comparable i, Comparable j) {
        return i.compareTo(j) > 0;
    }

}
