package top.treegrowth.java.reflect;

import java.util.Map;

/**
 * @author wusi
 * @version 2018/8/28.
 */
public class TypeTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
//        System.out.println(Map.class.newInstance());
        System.out.println(Long.class.isLocalClass());
//        System.out.println(Long.class.newInstance());
        System.out.println(TypeTest.class.isLocalClass());
    }
}
