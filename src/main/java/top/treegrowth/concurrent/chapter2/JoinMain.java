package top.treegrowth.concurrent.chapter2;

/**
 * @author wusi
 * @version 2017/2/23 6:59.
 */
public class JoinMain {
    public volatile static int i = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (i = 0; i<1000000; i++) {
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        addThread.start();
        //此处会等待循环完再打印，线程跟着addThread一起走
        addThread.join();
        System.out.println(i);
    }
}
