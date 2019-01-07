package top.treegrowth.concurrent.volatiletest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.treegrowth.BootStrapApp;

/**
 * @author wusi
 * @version 2018/8/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootStrapApp.class)
@SpringBootConfiguration
public class TestVolatile {
    @Autowired
    private VolatileTest volatileTest;

    @Test
    public void test() {
        volatileTest.start();
    }
}
