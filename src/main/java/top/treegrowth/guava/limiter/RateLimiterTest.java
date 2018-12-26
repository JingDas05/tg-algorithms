package top.treegrowth.guava.limiter;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author wusi
 * @version 2018/12/25.
 */
public class RateLimiterTest {

    final RateLimiter rateLimiter = RateLimiter.create(2.0);

    public void testConsume() {

    }
}
