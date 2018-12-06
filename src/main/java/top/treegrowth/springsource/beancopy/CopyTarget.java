package top.treegrowth.springsource.beancopy;

/**
 * @author wusi
 * @version 2018/9/3.
 */
public class CopyTarget {

    private String name;
    private Integer age;
    private Integer subAge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSubAge() {
        return subAge;
    }

    public void setSubAge(Integer subAge) {
        this.subAge = subAge;
    }

    @Override
    public String toString() {
        return "CopyTarget{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", subAge=" + subAge +
                '}';
    }
}
