package top.treegrowth.java.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wusi
 * @version 2018/8/14.
 */
public class ListAndArrayConvert {

    public static void main(String[] args) {
        List<String> elements = new ArrayList<>();
        elements.add("1");
        String[] strings = elements.toArray(new String[0]);
        elements.addAll(Arrays.asList("2", "3"));
        System.out.println(elements);
        System.out.println(ListAndArrayConvert.class.getName());
    }
}
