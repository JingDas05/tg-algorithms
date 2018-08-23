package top.treegrowth.springsource.beandefinition.simple;

import org.apache.commons.lang.StringUtils;

/**
 * 普通的bean,后面要用编程的方式生成
 *
 * @author wusi
 * @version 2018/8/23.
 */
public class BeanDefinitionCustom<T> {

    private String name;
    private Class<T> clazz;

    public BeanDefinitionCustom() {
    }

    public BeanDefinitionCustom(String name, Class<T> clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void start() throws NoSuchMethodException {
        if (!StringUtils.isEmpty(this.name)) {
            System.out.println("bean definition " + this.name + this.clazz.getMethod("innerMethod"));
        } else {
            System.out.println("bean definition start");
        }
    }
}
