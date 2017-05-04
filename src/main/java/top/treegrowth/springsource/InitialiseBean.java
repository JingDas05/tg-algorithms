package top.treegrowth.springsource;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wusi
 * @version 2017/5/4 8:56
 */
@Configuration
public class InitialiseBean implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("我被销毁了==========================================================================================================");
    }
}
