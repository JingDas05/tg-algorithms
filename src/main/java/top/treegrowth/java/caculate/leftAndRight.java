package top.treegrowth.java.caculate;

/**
 * @author wusi
 * @version 2018/1/23 15:44
 */
public class leftAndRight {

    public static void main(String[] args) {
        int tableSize = tableSizeFor(32);
        System.out.println(tableSize);
    }

    static final int tableSizeFor(int cap) {
        System.out.println(Integer.toBinaryString(cap));
        int n = cap - 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));
        return (n < 0) ? 1 : n + 1;
    }
}
