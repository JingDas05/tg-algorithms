package top.treegrowth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import top.treegrowth.mybatis.Client;
import top.treegrowth.concurrent.atomic.AtomicClient;
import top.treegrowth.concurrent.volatiletest.VolatileTest;

import javax.annotation.Resource;

/**
 * @author wusi
 * @version 2017/2/19 8:35.
 */
@SpringBootApplication
//如果是双数据源，需要用下面的启动类
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})")
public class BootStrapApp {

    @Resource
    private Client client;
    @Resource
    private VolatileTest volatileTest;
    @Resource
    private AtomicClient atomicClient;

    public static void main(String[] args) {
        SpringApplication.run(BootStrapApp.class, args);
    }

    @Configuration
    public class Start implements CommandLineRunner {
        @Override
        public void run(String... strings) throws Exception {
            try {
                //client.test();
                //volatileTest.start();
//                atomicClient.test();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
