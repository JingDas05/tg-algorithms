package top.treegrowth.jvm;

/**
 * @author wusi
 * @version 2017/2/26 8:00.
 */
public class TestSlotReuse {

    public static void main(String[] args) {
        localvar1();
        localvar2();
    }

    public static void localvar1() {
        int a = 0;
        System.out.println(a);
        int b = 0;
    }

    public static void localvar2() {
        {
            int a = 0;
            System.out.println(a);
        }
        int b = 0;
    }

}
