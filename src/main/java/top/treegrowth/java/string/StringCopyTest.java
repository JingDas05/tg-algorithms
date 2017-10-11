package top.treegrowth.java.string;

/**
 * @author wusi
 * @version 2017/9/7 14:19
 */
public class StringCopyTest {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test2() {
        String a = "aaa";
        String b= a;
        b = "bbb";
        System.out.println(b.replace("bb", "a"));
        System.out.println(b);
    }

    public static void test1() {
        String a = "aaa";
        String b= a;
        b = "bbb";
        System.out.println(a);
        System.out.println(b);
    }
}
