package top.treegrowth.springsource.beancopy;

/**
 * @author wusi
 * @version 2018/9/3.
 */
public class Parent {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                '}';
    }
}
