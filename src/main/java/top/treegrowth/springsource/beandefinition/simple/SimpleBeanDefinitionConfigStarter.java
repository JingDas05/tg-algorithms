package top.treegrowth.springsource.beandefinition.simple;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 配置类启动器
 *
 * @author wusi
 * @version 2018/8/22.
 */
@Configuration
@Import(SimpleBeanRegistryConfig.class)
public class SimpleBeanDefinitionConfigStarter {
}
