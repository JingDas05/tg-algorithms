package top.treegrowth.springsource.inject;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author Administrator
 */
public class DubboNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("service", new DubboBeanDefinitionParser());
    }
}
