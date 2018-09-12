package top.treegrowth.springsource.beancopy;

/**
 * @author wusi
 * @version 2018/9/3.
 */
public class Child extends Parent{

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Child{" +
                "age=" + age +
                '}';
    }
}
