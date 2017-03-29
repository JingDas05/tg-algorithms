package top.treegrowth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wusi
 * @version 2017/2/19 8:35.
 */
@SpringBootApplication
public class BootStrapApp {

    public static void main(String[] args) {
        SpringApplication.run(BootStrapApp.class, args);
    }

    public class Start implements CommandLineRunner {

        @Override
        public void run(String... strings) throws Exception {
            System.out.println("项目启动时，本方法会执行");
        }
    }
}
