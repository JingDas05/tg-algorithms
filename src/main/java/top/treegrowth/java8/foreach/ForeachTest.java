package top.treegrowth.java8.foreach;

import top.treegrowth.java8.grouptest.Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wusi
 * @version 2018/12/5.
 */
public class ForeachTest {

    public static void main(String[] args) {
        List<Demo> demos = new ArrayList<>();
        Demo demo1 = new Demo();
        demo1.setName("1");

        Demo demo2 = new Demo();
        demo2.setName("2");
        demos.add(demo1);
        demos.add(demo2);

        demos.forEach(each -> each.setName("3"));
        System.out.println(demos);
    }
}
