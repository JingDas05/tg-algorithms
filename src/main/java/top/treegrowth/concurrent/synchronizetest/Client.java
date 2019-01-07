package top.treegrowth.concurrent.synchronizetest;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author wusi
 * @version 2017/9/23 16:56.
 * synchronized关键字全类加锁
 */
public class Client {

    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();
        ThreadFactory factory = Executors.defaultThreadFactory();
        factory.newThread(new MyThread1(test)).start();
        factory.newThread(new MyThread2(test)).start();
    }
}
