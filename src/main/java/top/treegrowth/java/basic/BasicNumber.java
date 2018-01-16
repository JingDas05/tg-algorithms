package top.treegrowth.java.basic;

/**
 * @author wusi
 * @version 2017/12/23 17:39.
 */
public class BasicNumber {

    // TODO: 2017/12/23 需要弄清楚 -1 为什么是 10000000
    public static void main(String[] args) {
        short a = 128;
        int b = 1; 
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString((byte) a));
        System.out.println(Integer.toBinaryString(b));

        int number[] = {1,2,35,63};
    }
}
