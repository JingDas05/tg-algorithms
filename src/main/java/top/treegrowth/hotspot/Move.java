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
        // 进行32次循环（因为int有32位），每次循环取出int之中的一位，0x80000000是
        // 一个首位为1，其余位为0的整数，通过右移i位，定位到要获取的第i位，并将该
        // 位外的其他位统一置为0，而该位不变，最后将该位移至最右，并进行输出
        for (int i = 0; i < 32; i++) {
            int t = (a & 0x80000000 >>> i) >>> (31 - i);
            System.out.print(t);
        }
    }
}
