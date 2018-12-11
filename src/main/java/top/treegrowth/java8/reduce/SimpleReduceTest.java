package top.treegrowth.java8.reduce;

import java.util.stream.Stream;

/**
 * @author wusi
 * @version 2018/12/11.
 */
public class SimpleReduceTest {
    public static void main(String[] args) {

        SimpleReduceTest simple = new SimpleReduceTest();
        simple.test();
    }

    public void test() {
        Integer reduce = Stream.of(1, 2, 3, 4).reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }

}
