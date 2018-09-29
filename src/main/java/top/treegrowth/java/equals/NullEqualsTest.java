package top.treegrowth.java.equals;

import top.treegrowth.source.map.HashMap;
import top.treegrowth.source.map.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wusi
 * @version 2018/9/29.
 */
public class NullEqualsTest {

    public static void main(String[] args) {
//        Map<String, NullEqualsTest> map = new HashMap<>();
//        map.put("1", new NullEqualsTest(null));
//        System.out.println(Boolean.TRUE.equals(map.get("1").getName()));

//        Map<String, Boolean> map = new HashMap<>();
//        System.out.println(map.get("1")==true);

        List<NullEqualsTest> nullEqualsTests = new ArrayList<>();
        nullEqualsTests.add(new NullEqualsTest(null));
        nullEqualsTests.add(new NullEqualsTest(true));
        nullEqualsTests.add(new NullEqualsTest(true));

        List<NullEqualsTest> collect = nullEqualsTests.stream().filter(NullEqualsTest::getName).collect(Collectors.toList());

        System.out.println(collect.toArray());

    }

    public NullEqualsTest(Boolean name) {
        this.name = name;
    }

    private Boolean name;

    public Boolean getName() {
        return name;
    }

    public void setName(Boolean name) {
        this.name = name;
    }
}
