package top.treegrowth.java.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wusi
 * @version 2017/11/23 22:05.
 */
public class ArraySort {

    public static void main(String[] args) {
        Integer[] src = new Integer[]{1, 3, 4, 2, 6};
        Arrays.sort(src, new Comparator<Integer>() {
            // 按照升序排序的
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }
}
