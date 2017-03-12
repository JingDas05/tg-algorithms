package top.treegrowth.parallelism.chapter4.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wusi
 * @version 2017/3/12 6:53.
 */
public class ThreadLocalTest {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();
    public static ReentrantLock lock = new ReentrantLock();

    private static class ParseDateUnsafe implements Runnable {
        int i = 0;

        public ParseDateUnsafe(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                Date t = sdf.parse("2017-03-12 06:57:" + i % 60);
                System.out.println(t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ParseDateSafeWithLock implements Runnable {
        int i = 0;

        public ParseDateSafeWithLock(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                Date t = sdf.parse("2017-03-12 06:57:" + i % 60);
                lock.unlock();
                System.out.println(t);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ParseDateSafeWithLocal implements Runnable {
        int i = 0;

        public ParseDateSafeWithLocal(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if (threadLocal.get() == null) {
                    threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                Date t = threadLocal.get().parse("2017-03-12 07:37:" + i % 60);
                System.out.println(t);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            es.execute(new ParseDateUnsafe(i));
            //es.execute(new ParseDateSafeWithLock(i));
            //es.execute(new ParseDateSafeWithLocal(i));
        }
    }
}
