package top.treegrowth.mybatis;

import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @author wusi
 */
@Component
public class Client {

    @Resource
    private MyService myService;

    public void test() {
        myService.insert();
    }
}
