package top.treegrowth.springsource.inject;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author Administrator
 */
public class ServiceBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化" + this.getClass().getName());
    }
}
