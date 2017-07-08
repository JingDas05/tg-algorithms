package top.treegrowth.java.publishervslistener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author wusi
 * @version 2017/3/28 7:38.
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent event) {
        System.out.println(event.getMsg());
    }
}
