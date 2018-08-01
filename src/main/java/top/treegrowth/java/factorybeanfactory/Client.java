package top.treegrowth.java.factorybeanfactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wusi
 */
public class Client {

    public static void main(String[] args) {
        String url = "factorybeanfactory/BeanConfig.xml";
        ClassPathXmlApplicationContext cpxa = new ClassPathXmlApplicationContext(url);
        // factoryBeanPojo 实现了 FactoryBean接口， 之后getBean() 方法获取的是 getObject() 实际返回的值
        Object school = cpxa.getBean("factoryBeanPojo");
        // &+类名，是获取实际的实现类
        FactoryBeanPojo factoryBeanPojo = (FactoryBeanPojo) cpxa.getBean("&factoryBeanPojo");
        System.out.println(school.getClass().getName());
        System.out.println(factoryBeanPojo.getClass().getName());
    }
}
