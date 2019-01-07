package top.treegrowth.concurrent;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wusi
 * @version 2017/7/1 10:44.
 */
public class ConcurrentMap {

    public static void main(String[] args) {
        TestCommonMap testCommonMap = new TestCommonMap();
        TestConcurrentMap testConcurrentMap = new TestConcurrentMap();

        for (int i = 0; i< 5000; i++) {
            new Thread(() -> testCommonMap.add("key")).run();
        }

        for (int i = 0; i< 5000; i++) {
            new Thread(() -> testConcurrentMap.add("key")).run();
        }
        testCommonMap.print();
        testConcurrentMap.print();
    }


    public static class TestCommonMap {
        private HashMap<String, Integer> map = new HashMap<>();
        private String key;

        public void add(String key) {
            this.key = key;
            Integer value = map.get(key);
            if (value == null) {
                map.put(key, 1);
            } else {
                map.put(key, value + 1);
            }
        }

        public void print() {
            System.out.println("普通map" + map.get(key));
        }
    }

    public static class TestConcurrentMap {
        private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        private String key;
        public  void add(String key) {
            this.key = key;
            Integer value = map.get(key);
            if (value == null){
                map.put(key, 1);
            }else {
                map.put(key, value+1);
            }
        }

        public void print() {
            System.out.println("多线程map"+ map.get(key));
        }
    }
}

