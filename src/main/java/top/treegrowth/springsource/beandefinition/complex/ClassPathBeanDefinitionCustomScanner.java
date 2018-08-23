package top.treegrowth.springsource.beandefinition.complex;

import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 * 根据路径的类注册器，registerFilters()方法是添加过滤器
 *
 * @author wusi
 * @version 2018/8/22.
 */
public class ClassPathBeanDefinitionCustomScanner extends ClassPathBeanDefinitionScanner {

    private ComplexBeanDefinitionCustomFactoryBean<?> complexBeanDefinitionCustomFactoryBean = new ComplexBeanDefinitionCustomFactoryBean<Object>();

    public ClassPathBeanDefinitionCustomScanner(BeanDefinitionRegistry registry) {
        super(registry, false);
    }

    private ComplexBeanDefinitionCustomFactoryBean<?> mapperFactoryBean = new ComplexBeanDefinitionCustomFactoryBean<Object>();

    // 只注册标记有SelfConfigAnnotation注解的类
    public void registerFilters() {
        addIncludeFilter(new AnnotationTypeFilter(SelfConfigAnnotation.class));
    }

    @Override
    public Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
        GenericBeanDefinition definition;
        for (BeanDefinitionHolder holder : beanDefinitions) {
            definition = (GenericBeanDefinition) holder.getBeanDefinition();
            // 这个地方很巧妙，先是通过扫描获取实际标注的SelfConfigAnnotation注解的类名，之后下面设置的是 factoryBean,factoryBean的
            // 特性就是注入的时候，注入的是getObject()方法获取的实例
            definition.getConstructorArgumentValues().addGenericArgumentValue(definition.getBeanClassName());
            definition.setBeanClass(complexBeanDefinitionCustomFactoryBean.getClass());
        }
        // 返回实例就大功告成了，之后进行注册
        return beanDefinitions;
    }
}
