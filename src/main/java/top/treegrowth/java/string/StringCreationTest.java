package top.treegrowth.java.string;

/**
 * @author wusi
 * @version 2017/10/13 11:21
 */
public class StringCreationTest {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");
        char[] s5 = {'a', 'b', 'c'};
        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
        System.out.println(s3.intern() == s4.intern());
        System.out.println(s5.equals(s1));
    }
}
