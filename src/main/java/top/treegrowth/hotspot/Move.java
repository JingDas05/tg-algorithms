package top.treegrowth.hotspot;

/**
 * @author wusi
 * @version 2017/2/22 23:07.
 */
public class Move {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int a = -10;
        for (int i = 0; i < 32; i++) {
            int t = (a & 0x80000000 >>> i) >>> (31 - i);
            System.out.print(t);
        }
    }
}
