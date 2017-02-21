package top.treegrowth.parallelism;

/**
 * @author wusi
 * @version 2017/2/21 19:56.
 */
public class SimpleThread implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(
                new SimpleThread()
        );
        thread.start();
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 1000000) {
            System.out.println(i);
            i++;
        }
    }
}
