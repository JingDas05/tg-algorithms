package top.treegrowth.springsource.beandefinition.complex;

/**
 * 自己定义的需要编程注入的bean
 *
 * @author wusi
 * @version 2018/8/22.
 */
@SelfConfigAnnotation
public class ComplexBeanDefinitionCustom {

    public void start() {
        System.out.println("complex bean definition start");
    }
}
