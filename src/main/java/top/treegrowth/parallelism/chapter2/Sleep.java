package top.treegrowth.parallelism.chapter2;

/**
 * @author wusi
 * @version 2017/2/23 6:49.
 */
public class Sleep {
    public static Object u = new Object();

    public static class SleepThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("11223334");
                Thread.yield();
            }
        }
    }

    //为什么已经休眠了还在打印？？？？？
    public static void main(String[] args) throws InterruptedException {
        SleepThread thread = new SleepThread();
        thread.start();
        Thread.sleep(100000);
    }
}
