package top.treegrowth.java.string;

/**
 * @author wusi
 * @version 2018/12/27 22:53.
 */
public class StringEqualsTest {

    private String a = "a";
    private String b = "b";
    private String bc = "bc";
    private String abc = "abc";
    private String aAndBc = a + "bc";
    private String abAndC = "ab" + "c";
    private String acAndB = "a" + b + "c";


    public static void main(String[] args) {
        StringEqualsTest stringEqualsTest = new StringEqualsTest();
        stringEqualsTest.test();
    }

    public void test() {
        System.out.println(abc == aAndBc);
        System.out.println(abc == abAndC);
        System.out.println(abc == acAndB);
    }
}
