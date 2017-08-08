package top.treegrowth.java.maptest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wusi
 * @version 2017/8/7 16:43
 */
public class MapAddTest {

    public static void main(String[] args) {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("key", String.valueOf(i));
            list.add(map);
        }
        System.out.println(list);
    }
}
