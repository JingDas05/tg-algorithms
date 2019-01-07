package top.treegrowth.concurrent.synchronizetest;

/**
 * @author wusi
 * @version 2017/9/23 16:54.
 */
public class MyThread1 implements Runnable {

    private SynchronizedTest test;

    public MyThread1(SynchronizedTest test) {
        this.test = test;
    }

    @Override
    public void run() {
        test.method1();
    }
}
