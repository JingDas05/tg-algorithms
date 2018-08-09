package top.treegrowth.parallelism.atomic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wusi
 * @version 2018/8/9.
 */
@Service
public class AtomicClient {

    @Autowired
    private FakeLimitedResource fakeLimitedResource;

    public void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fakeLimitedResource.use();
                } catch (InterruptedException e) {
                    System.out.println( Thread.currentThread().getName()+"InterruptedException");
                }
            }
        }).start();
        System.out.println(fakeLimitedResource.getInUse());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fakeLimitedResource.use();
                } catch (InterruptedException e) {
                    System.out.println( Thread.currentThread().getName()+"InterruptedException");
                }
            }
        }).start();
        System.out.println(fakeLimitedResource.getInUse());
    }
}
