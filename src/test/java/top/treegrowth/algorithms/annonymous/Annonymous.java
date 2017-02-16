package top.treegrowth.algorithms.annonymous;

import java.util.*;

public class Annonymous {

    private static List<Integer> l = Arrays.asList(1, 2, 68, 5);

    public static void main(String[] args) {
        System.out.println(l);
        compare();
        System.out.println(l);

        //自定义compare
        test(new Compare() {
            @Override
            public int compare(Object v1, Object v2) {
                return 0;
            }
        });
    }

    //官方的做法
    public static void compare() {
        Collections.sort(l, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

    //用自定义的compare
    public static void test(Compare c) {

    }
}
