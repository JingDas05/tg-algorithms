package top.treegrowth.java8.grouptest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wusi
 * @version 2018/12/5.
 */
public class GroupTest {

    public static void main(String[] args) {
        List<Demo> demos = new ArrayList<>();
        Demo demo1 = new Demo();
        demo1.setName("1");

        Demo demo2 = new Demo();
        demo2.setName("2");
        demos.add(demo1);
        demos.add(demo2);

        Map<String, List<Demo>> stringListMap = demos.stream().collect(Collectors.groupingBy(Demo::getName));
        System.out.println(stringListMap);
    }
}
