package top.treegrowth.concurrent;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * hashMap concurrentHashMap 并发操作测试
 *
 * @author wusi
 * @version 2017/7/1 10:44.
 */
public class ConcurrentMap {

    private class ConcurrentMapThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = newThread(r);
            thread.setName("ConcurrentMap" + System.currentTimeMillis());
            return thread;
        }
    }

    private ExecutorService executorService = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(), new ConcurrentMapThreadFactory());

    public void main(String[] args) {
        TestCommonMap testCommonMap = new TestCommonMap();
        TestConcurrentMap testConcurrentMap = new TestConcurrentMap();

        for (int i = 0; i < 5000; i++) {
            executorService.submit(() -> testCommonMap.add("key"));
        }

        for (int i = 0; i < 50000; i++) {
            executorService.submit(() -> testConcurrentMap.add("key"));
        }
        testCommonMap.print();
        testConcurrentMap.print();
    }


    public static class TestCommonMap {
        private HashMap<String, Integer> map = new HashMap<>();
        private String key;

        public void add(String key) {
            this.key = key;
            // map hashMap 函数式操作，value 自增 自然数
            map.merge(key, 1, (a, b) -> a + b);
        }

        public void print() {
            System.out.println("普通map" + map.get(key));
        }
    }

    public static class TestConcurrentMap {
        private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
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
            System.out.println("多线程map" + map.get(key));
        }
    }
}

