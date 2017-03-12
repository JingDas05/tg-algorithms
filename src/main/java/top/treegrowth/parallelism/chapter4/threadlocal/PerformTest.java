package top.treegrowth.parallelism.chapter4.threadlocal;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 测试直接new， 与从threadLocal中取的性能区别
 *
 * @author wusi
 * @version 2017/3/12 22:11.
 */
public class PerformTest {

    public static final int GEN_COUNT = 10000000;
    public static final int THREAD_COUNT = 4;
    static ExecutorService exe = Executors.newFixedThreadPool(THREAD_COUNT);
    //直接new
    public static Random rnd = new Random(123);
    //从threadLocal中取
    public static ThreadLocal<Random> tRnd = new ThreadLocal<Random>() {
        @Override
        protected Random initialValue() {
            return new Random(123);
        }
    };

    public static class RndTask implements Callable<Long> {

        private int model = 0;

        public RndTask(int model) {
            this.model = model;
        }

        public Random getRandom() {
            if (model == 0) {
                return rnd;
            } else if (model == 1) {
                return tRnd.get();
            } else {
                return null;
            }
        }

        //注意这个地方实现的Callable接口的方法
        @Override
        public Long call() throws Exception {
            long b = System.currentTimeMillis();
            for (long i = 0; i < GEN_COUNT; i++) {
                getRandom().nextInt();
            }
            long e = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "spend" + (e - b) + "ms");
            return e - b;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //测试访问同一个实例
        Future<Long>[] futures = new Future[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            futures[i] = exe.submit(new RndTask(0));
        }
        long totalTime = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            totalTime += futures[i].get();
        }
        System.out.println("多线程访问同一个Random实例："+ totalTime+"ms");

        //测试ThreadLocal 的情况
        for (int i = 0; i < THREAD_COUNT; i++) {
            futures[i] = exe.submit(new RndTask(1));
        }
        totalTime = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            totalTime += futures[i].get();
        }
        System.out.println("使用ThreadLocal包装的Random实例："+ totalTime+"ms");
    }

}
