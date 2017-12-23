package top.treegrowth.java.assertTest;

/**
 * @author wusi
 * @version 2017/12/20 7:19.
 */
public class AssertTest {

    public static void main(String[] args) {
        assert 1 + 1 == 2;
        System.out.println("assert1 ok");

        assert 1 + 12 == 2 : "assert1 faild";
        System.out.println("assert1 ok");
    }
}
