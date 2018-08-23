package top.treegrowth.springsource.beandefinition.complex;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author wusi
 * @version 2018/8/22.
 */
public class ComplexBeanRegistryConfig implements BeanFactoryAware, ImportBeanDefinitionRegistrar, ResourceLoaderAware {

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
        // 通过ClassPathBeanDefinitionCustomScanner服务，扫描bean，并且注册
        ClassPathBeanDefinitionCustomScanner scanner = new ClassPathBeanDefinitionCustomScanner(beanDefinitionRegistry);
        scanner.registerFilters();
        scanner.doScan("top.treegrowth.springsource");
    }
}
