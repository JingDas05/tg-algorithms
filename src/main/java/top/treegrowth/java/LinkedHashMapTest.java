package top.treegrowth.java;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wusi
 * @version 2017/8/13 13:47.
 */
public class LinkedHashMapTest {

    private static Map<Object, Object> map = new LinkedHashMap<>(20, .75F, true);

    public static void main(String[] args) {
        map.put("1", "a");
        map.put("3", "c");
        map.put("2", "b");
        map.put("4", "d");
        map.put("5", "e");

//        for (Map.Entry<Object, Object> entry : map.entrySet()) {
//            System.out.println("key:" + entry.getKey() + ", value" + entry.getValue());
//        }

        map.get("5");
        map.get("3");
        map.get("4");
        map.get("4");
        map.get("2");
        map.get("1");

        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + ", value" + entry.getValue());
        }
    }
}
