package top.treegrowth.springsource.beandefinition.complex;

import org.springframework.beans.factory.FactoryBean;

/**
 * 这个实现了factoryBean接口，意味着自动注入的时候，获取的实例调用的是下面的getObject()方法
 *
 * @author wusi
 * @version 2018/8/22.
 */
public class ComplexBeanDefinitionCustomFactoryBean<T> implements FactoryBean<T> {

    private Class<T> selfConfig;

    public ComplexBeanDefinitionCustomFactoryBean() {
    }

    public ComplexBeanDefinitionCustomFactoryBean(Class<T> selfConfig) {
        this.selfConfig = selfConfig;
    }

    public Class<T> getSelfConfig() {
        return selfConfig;
    }

    public void setSelfConfig(Class<T> selfConfig) {
        this.selfConfig = selfConfig;
    }

    @Override
    public T getObject() throws Exception {
        return this.selfConfig.newInstance();
    }

    @Override
    public Class<?> getObjectType() {
        return this.selfConfig;
    }
}
