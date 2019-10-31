package top.treegrowth.concurrent.atomic;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * bool 布尔值的原子操作
 *
 * @author wusi
 * @version 2018/8/9.
 */
@Component
public class FakeLimitedResource {

    private final AtomicBoolean inUse = new AtomicBoolean(false);

    public void use() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        // in a real application this would be accessing/manipulating a shared resource
        if (!inUse.compareAndSet(false, true)) {
            throw new IllegalStateException("Needs to be used by one client at a time");
        }

        try {
//            Thread.sleep((long) (3 * Math.random()));
            Thread.sleep(5000);
        } finally {
            inUse.set(false);
        }
    }

    public AtomicBoolean getInUse() {
        return inUse;
    }
}
