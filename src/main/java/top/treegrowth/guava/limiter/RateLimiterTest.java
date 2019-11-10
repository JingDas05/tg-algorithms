package top.treegrowth.guava.limiter;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author wusi
 * @version 2018/12/25.
 */
public class RateLimiterTest {



    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.create(0.1);
        for (int i = 0; i < 5; i++) {
            //acquire方法传入的是需要的令牌个数，当令牌不足时会进行等待，该方法返回的是等待的时间
            double waitTime = rateLimiter.acquire(10);
            boolean result = rateLimiter.tryAcquire();
            System.out.println("waitTime," + waitTime);
            System.out.println("threadId gain result," + result);
            System.out.println("threadId," + Thread.currentThread().getId());
        }
    }
}
