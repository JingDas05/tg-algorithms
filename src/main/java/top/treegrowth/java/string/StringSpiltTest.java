package top.treegrowth.java.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wusi
 * @version 2018/9/26.
 */
public class StringSpiltTest {

    public static void main(String[] args) {
        String[] split = "4,5,6，9，8".split("[,，]");
        System.out.println(split.toString());
        Set set = new HashSet();
        set.add(new Integer("1"));
//        set.add(new Long("1"));
//        set.add(new Long("1"));
//        set.add(1L);
        set.add("2");
        System.out.println(set.contains("2"));
    }
}
