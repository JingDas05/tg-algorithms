package top.treegrowth.designmodel.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wusi
 * @version 2017/7/27 8:56
 */
public class Thing implements Cloneable {

    public Thing() {
        System.out.println("原型的构造函数被调用了");
    }

    // 这个地方不能用List, 因为List没有实现Cloneable接口，需要使用ArrayList
    private ArrayList<String> list = new ArrayList<>();
    private String name;

    public String getList() {
        return list.get(0);
    }

    public void setList(String listName) {
        this.list.add(0, listName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Thing clone() {
        Thing thing = null;
        try {
            thing = (Thing) super.clone();
            // 加上这个后，Client中的复制就没有问题了，复制数组了，注释掉的话Client中，复制对象的引用和原型中的是一样的
            this.list = (ArrayList<String>)this.list.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return thing;
    }
}
