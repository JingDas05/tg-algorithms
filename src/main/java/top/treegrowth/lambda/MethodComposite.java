package top.treegrowth.lambda;

import java.util.function.Function;

/**
 * @version 2017/2/14.
 */
public class MethodComposite {

    public static void main(String[] args) {
        testComposite();
        pipeline();
    }

    //流水线
    public static void pipeline() {
        Function<String, String> addHeader = (header) -> {
            Letter letter = new Letter();
            return Letter.addHeader(header);
        };

        //方法引用写法如下
        Function<String, String> addHeaderSimple = Letter::addHeader;
        Function<String, String> addBodySimple = Letter::addBody;
        Function<String, String> addFooterSimple = Letter::addFooter;
        Function<String, String> pipeLine = addHeaderSimple.andThen(addBodySimple).andThen(addFooterSimple);
        System.out.println(addBodySimple.apply("w1111"));
        System.out.println(pipeLine.apply(""));
    }

    static class Letter {

        public static String addHeader(String text) {
            return "add header" + text;
        }

        public static String addBody(String text) {
            return "add body"+ text;
        }

        public static String addFooter(String text) {
            return "add footer"+ text;
        }
    }

    public static void testComposite() {
        //T 操作数，R返回数
        Function<Integer, Integer> f = x -> x +1;
        Function<Integer, Integer> g = x -> 2 * x;
        Function<Integer, Integer> h = f.andThen(g);
        //结果应该为4 （1+1）*2, 上面的f和g 互换结果就是（1*2）+1
        System.out.println(h.apply(1));
        //等价于上面的
        Function<Integer, Integer> h2 = g.compose(f);
        System.out.println(h2.apply(1));
    }

    public static void testFunctionInterface() {
        //T 操作数，R返回数
        Function<Integer, String> f = String::valueOf;
        System.out.println(f.apply(1));
    }

}
