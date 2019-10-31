package top.treegrowth.springsource.beancopy;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wusi
 * @version 2018/9/3.
 */
public class Client {

    public static void main(String[] args) {

        SubObject subObject = new SubObject();
        subObject.setCode(9);
        List<SubObject> subObjects = new ArrayList<>();
        subObjects.add(subObject);

        Child child = new Child();
        child.setName("a");
        child.setAge(10);
        child.setSubObjects(subObjects);

        System.out.println(copy(child));
    }


    public static CopyTarget copy(Parent parent) {
        CopyTarget copyTarget = new CopyTarget();
        BeanUtils.copyProperties(parent, copyTarget);
        return copyTarget;
    }
}
