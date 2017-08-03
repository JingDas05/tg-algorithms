package top.treegrowth.algorithms.common;

import java.io.Serializable;

/**
 * @author wusi
 * @version 20170212
 */
public class Utils implements Serializable {

    public static void exchange(Comparable[] source, int i, int j) {
        Comparable temp = source[i];
        source[i] = source[j];
        source[j] = temp;
    }

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    public static boolean more(Comparable i, Comparable j) {
        return i.compareTo(j) > 0;
    }

    public static void print(Object[] source) {
        for (Object each : source) {
            System.out.println("" + each.toString());
        }
    }
}
