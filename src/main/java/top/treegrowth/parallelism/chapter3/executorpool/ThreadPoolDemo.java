package top.treegrowth.parallelism.chapter3.executorpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wusi
 * @version 2017/2/26 11:37.
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }
    }

    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread Id:" + Thread.currentThread().getId());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
