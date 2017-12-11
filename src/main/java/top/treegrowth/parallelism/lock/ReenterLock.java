package top.treegrowth.parallelism.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wusi
 * @version 2017/12/10 8:07.
 */
public class ReenterLock implements Runnable{

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        ReenterLock.i = i;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int j = 0; j < 100000; j++) {
            lock.lock();
            try {
                i++;
                System.out.println("i value is:" + i);
            } finally {
                lock.unlock();
            }
        }
    }
}
