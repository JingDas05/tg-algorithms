package top.treegrowth.java;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class TestAddAll {

    public static void main(String[] args) {

        new TestAddAll().test();
    }

    public void test() {
        List a = new ArrayList();
        a.add(1);
        a.add(2);
        List b = new ArrayList();
        b.add(3);
        b.add(4);

        CollectionUtils.addAll(a, b.iterator());
        System.out.println(a.toArray());
    }
}
