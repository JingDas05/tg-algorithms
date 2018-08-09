package top.treegrowth;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wusi
 * @version 2018/8/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootStrapApp.class)
@SpringBootConfiguration
public class BaseTest {

    @Before
    public void before() {
        System.out.println("===================begin test====================");
    }
}
