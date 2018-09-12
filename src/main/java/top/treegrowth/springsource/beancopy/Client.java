package top.treegrowth.springsource.beancopy;

import org.springframework.beans.BeanUtils;

/**
 * @author wusi
 * @version 2018/9/3.
 */
public class Client {

    public static void main(String[] args) {

        Child child = new Child();
        child.setName("a");
        child.setAge(10);

        CopyTarget copyTarget = new CopyTarget();
        BeanUtils.copyProperties(child, copyTarget);
        System.out.println(copy(child));
    }


    public static CopyTarget copy(Parent parent) {
        CopyTarget copyTarget = new CopyTarget();
        BeanUtils.copyProperties(parent, copyTarget);
        return copyTarget;
    }
}
