package top.treegrowth.concurrent.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wusi
 * @version 2018/12/28 8:41.
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("key", "value");
        System.out.println(map.get("key"));
        map.contains("value");
        map.containsKey("key");
        map.entrySet();
        map.keySet();
        map.values();
        map.clear();
    }
}
