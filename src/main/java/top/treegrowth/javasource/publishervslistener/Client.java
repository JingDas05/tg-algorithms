package top.treegrowth.javasource.publishervslistener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wusi
 * @version 2017/3/28 7:42.
 */
public class Client {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher demoPublisher = (DemoPublisher)context.getBean("demoPublisher");
        demoPublisher.publish("清晨的第一个消息");
    }
}
