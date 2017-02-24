package top.treegrowth.designmodel.specification.model;

/**
 * AbstractModel 应该为Object，抽象成Object怕忘了具体条件的判断
 *
 * @author wusi
 * @version 2017/2/24 9:12
 */
public class AbstractModel {

    private String name;
    private int age;

    public AbstractModel() {
    }

    public AbstractModel(String name, int age) {
        this.name = name;
        this.age = age;
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
}
