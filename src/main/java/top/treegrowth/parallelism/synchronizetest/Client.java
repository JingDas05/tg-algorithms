package top.treegrowth.parallelism.synchronizetest;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author wusi
 * @version 2017/9/23 16:56.
 */
public class Client {

    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();
        ThreadFactory factory = Executors.defaultThreadFactory();
        factory.newThread(new MyThread1(test)).start();
        factory.newThread(new MyThread2(test)).start();
    }
}
