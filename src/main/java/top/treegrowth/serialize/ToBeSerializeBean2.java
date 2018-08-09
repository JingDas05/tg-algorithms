package top.treegrowth.serialize;

import java.util.List;

/**
 * @author wusi
 * @version 2018/8/9.
 */
public class ToBeSerializeBean2<T> {

    private List<T> list;
    private T bean;
    private String name;
    private int age;

    public ToBeSerializeBean2() {
    }

    public ToBeSerializeBean2(List<T> list, T bean, String name, int age) {
        this.list = list;
        this.bean = bean;
        this.name = name;
        this.age = age;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getBean() {
        return bean;
    }

    public void setBean(T bean) {
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

    @Override
    public String toString() {
        return "ToBeSerializeBean2{" +
                "list=" + list +
                ", bean=" + bean +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
