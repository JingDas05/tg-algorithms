package top.treegrowth.concurrent.synchronizetest;

/**
 * @author wusi
 * @version 2017/9/23 16:56.
 */
public class MyThread2 implements Runnable{

    private SynchronizedTest test;

    public MyThread2(SynchronizedTest test) {
        this.test = test;
    }

    @Override
    public void run() {
        test.method2();
    }
}
