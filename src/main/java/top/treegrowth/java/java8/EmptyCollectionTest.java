package top.treegrowth.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wusi
 * @version 2018/8/31.
 */
public class EmptyCollectionTest {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        Set<Integer> collect = strings.stream().map(Integer::parseInt).collect(Collectors.toSet());
        System.out.println(collect);
    }
}
