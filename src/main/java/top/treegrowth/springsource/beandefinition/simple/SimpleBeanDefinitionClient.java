package top.treegrowth.springsource.beandefinition.simple;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 *
 * 程序调用客户端
 *
 * @author wusi
 * @version 2018/8/23.
 */
@Component
public class SimpleBeanDefinitionClient {

    @Resource
    private BeanDefinitionCustom beanDefinitionTest;

    @PostConstruct
    public void start() throws NoSuchMethodException {
        beanDefinitionTest.start();
    }
}
