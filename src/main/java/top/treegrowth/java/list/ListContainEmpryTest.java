package top.treegrowth.java.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wusi
 * @since 2019-06-24 17:32
 */
public class ListContainEmpryTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add(null);
        list.add(null);

        for (String element: list) {
            System.out.println(element);
        }
        System.out.println(list.contains(null));
    }
}
