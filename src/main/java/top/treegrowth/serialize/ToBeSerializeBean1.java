package top.treegrowth.serialize;

import java.util.List;

/**
 * @author wusi
 * @version 2018/8/9.
 */
public class ToBeSerializeBean1 {

    private List<Bean> list;
    private Bean bean;
    private String name;
    private int age;

    public ToBeSerializeBean1() {

    }

    public ToBeSerializeBean1(List<Bean> list, Bean bean, String name, int age) {
        this.list = list;
        this.bean = bean;
        this.name = name;
        this.age = age;
    }

    public Bean getBean() {
        return bean;
    }

    public void setBean(Bean bean) {
        this.bean = bean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Bean> getList() {
        return list;
    }

    public void setList(List<Bean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ToBeSerializeBean1{" +
                "list=" + list +
                ", bean=" + bean +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
