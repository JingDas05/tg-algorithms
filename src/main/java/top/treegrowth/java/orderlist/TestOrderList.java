package top.treegrowth.java.orderlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class TestOrderList {

    private static List<Integer> ids = new ArrayList<>();
    private static List<Integer> ids2 = new LinkedList<>();

    static {
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(5);
        ids.add(6);
        ids2.add(1);
        ids2.add(2);
        ids2.add(3);
    }

    public static void main(String[] args) {
        List<Integer> newIds = new ArrayList<>();
        for (Integer each : ids) {
//            System.out.println(each);
            newIds.add(each);
        }

        for (Integer each : newIds) {
            System.out.println(each);
        }

//        for (Integer each : ids2) {
//            System.out.println(each);
//        }
    }
}
