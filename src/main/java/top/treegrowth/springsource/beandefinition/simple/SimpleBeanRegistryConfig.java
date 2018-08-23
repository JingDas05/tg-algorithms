package top.treegrowth.springsource.beandefinition.simple;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 编程的方式生成bean
 *
 * @author wusi
 * @version 2018/8/22.
 */
public class SimpleBeanRegistryConfig implements BeanFactoryAware, ImportBeanDefinitionRegistrar, ResourceLoaderAware {

    private BeanFactory beanFactory;
    private ResourceLoader resourceLoader;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;

    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(BeanDefinitionCustom.class);
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("constructor");
        // 这个类的第二个构造器参数是class，spring会根据类型寻找class字节码文件
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("top.treegrowth.springsource.beandefinition.simple.SimpleInnerClass");
        beanDefinitionRegistry.registerBeanDefinition("beanDefinitionTest", beanDefinition);
    }
}
