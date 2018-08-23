package top.treegrowth.serialize;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.treegrowth.BaseTest;

/**
 * @author wusi
 * @version 2018/8/9.
 */
public class TestSerializeAtomicSelfConfigClientTest extends BaseTest {

    @Autowired
    SerializeClient serializeClient;

    @Test
    public void testSerializeClient() throws Exception {
        serializeClient.test();
    }
}
