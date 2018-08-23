package top.treegrowth.springsource.beandefinition.complex;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * 配置开始的入口
 *
 * @author wusi
 * @version 2018/8/22.
 */
@Configuration
@Import(ComplexBeanRegistryConfig.class)
public class ComplexBeanDefinitionConfigStarter {
}
