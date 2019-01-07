package top.treegrowth.concurrent.executors.duration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wusi
 * @version 2018/8/9.
 */
public class TestScheduledExecuorService {

    // 创建线程池
    private static final ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(atomicInteger.getAndIncrement());
//                throw new  RuntimeException();
            }
        };
        scheduledThreadPool.scheduleAtFixedRate(runnable, 100, 1000, TimeUnit.MILLISECONDS);

    }
}
