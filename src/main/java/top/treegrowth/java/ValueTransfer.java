package top.treegrowth.java;

/**
 * @author wusi
 * @version 2018/4/5 8:17.
 */
public class ValueTransfer {

    private static Integer a = 9;

    public static void main(String[] args) {
        changeNum(a);
    }

    public static void changeNum(Integer b) {
        b = 10;
        System.out.println(b);
        System.out.println(a);
    }
}
