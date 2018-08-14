package top.treegrowth.springsource.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author wusi
 * @version 2018/8/14.
 */
public class ComponentInject implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("==============================注入========================================");
        System.out.println(this.applicationContext);
    }

}
