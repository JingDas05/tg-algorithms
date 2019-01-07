package top.treegrowth.concurrent.atomic;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.treegrowth.BaseTest;

/**
 * @author wusi
 * @version 2018/8/9.
 */
public class AtomicClientTest extends BaseTest {

    @Autowired
    private AtomicClient atomicClient;

    @Test
    public void test() {
        atomicClient.test();
    }
}
