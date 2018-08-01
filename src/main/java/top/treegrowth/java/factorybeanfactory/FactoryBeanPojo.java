package top.treegrowth.java.factorybeanfactory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author wusi
 */
public class FactoryBeanPojo implements FactoryBean {

    private String type;

    @Override
    public Object getObject() throws Exception {
        if ("student".equals(type)) {
            return new Student();
        } else {
            return new School();
        }

    }

    @Override
    public Class getObjectType() {
        return School.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
