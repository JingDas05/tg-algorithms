package top.treegrowth.parallelism.blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author wusi
 * @version 2018/8/6.
 */
public class BlockQueueTest {

    private static final BlockingQueue<String> queue = new LinkedBlockingQueue<>(100000);

    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            while (true) {
                try {
                    // take() 方法会阻塞当前线程
                    System.out.println(queue.take());
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(5000);
        queue.offer("first");
        Thread.sleep(5000);
        queue.offer("second");
    }
}
