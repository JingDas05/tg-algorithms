package top.treegrowth.concurrent.chapter3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wusi
 * @version 2017/2/24 21:53.
 */
public class ReenterLock implements Runnable {
    //重入锁
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;
    Lock commonLock;

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock t1 = new ReenterLock();
        Thread a = new Thread(t1);
        Thread b = new Thread(t1);
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println(i);
    }
}
