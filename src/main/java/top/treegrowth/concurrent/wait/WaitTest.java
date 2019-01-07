package top.treegrowth.concurrent.wait;

/**
 * @author wusi
 * @version 2018/12/28 8:06.
 */
public class WaitTest {

    private int waitingWriters = 0;
    private int writingWriters = 0;

    public static void main(String[] args) throws InterruptedException {
        WaitTest waitTest = new WaitTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitTest.writeLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitTest.writeLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("wait 5000ms");
        Thread.sleep(500);
        waitTest.notifyThread();
    }


    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;
        try {
            wait();
        } finally {
            System.out.println("finally");
            waitingWriters--;
        }
        writingWriters++;
    }

    public synchronized void notifyThread() {
        notifyAll();
    }
}
