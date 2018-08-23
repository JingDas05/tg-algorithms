package top.treegrowth.springsource.beandefinition.complex;

import org.springframework.stereotype.Component;
import top.treegrowth.springsource.beandefinition.simple.BeanDefinitionCustom;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 *
 *
 * 这个地方是模拟的Mybatis-spring的 mapper接口自动注入的原理
 *
 * @author wusi
 * @version 2018/8/23.
 */
@Component
public class ComplexBeanDefinitionClient {


    @Resource
    private ComplexBeanDefinitionCustom complexBeanDefinitionCustom;

    @PostConstruct
    public void start() throws NoSuchMethodException {
        complexBeanDefinitionCustom.start();
    }
}
