package top.treegrowth.parallelism.chapter2;

/**
 * @author wusi
 * @version 2017/2/23 7:11.
 */
public class Volatile {
//    如果是这种写法，多线程不可见，那么while(!ready) 永远不会退出，并且打印
//    private static boolean ready;
//    private static int num;

    //改为volatile 就可以了，这个可以通知虚拟机这个地方尤其注意
    private volatile static boolean ready;
    private volatile static int num;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) ;
            System.out.println(num);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        num = 42;
        ready = true;
        Thread.sleep(10000);
    }
}
