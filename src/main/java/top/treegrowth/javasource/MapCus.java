package top.treegrowth.javasource;

import java.util.Map;

/**
 * @author wusi
 * @version 2017/3/29 7:12.
 */
public class MapCus {

    Map map;

    public static void main(String[] args) {

        hashcode();

    }

    private static void hashcode() {
        int l = 178934;
        int l1 = l >>> 3;
        int l2 = l >> 3;
        int l3 = l << 3;

        //Integer四个字节
        System.out.println(Integer.toBinaryString(l));
        System.out.println(Integer.toBinaryString(l1));
        System.out.println(Integer.toBinaryString(l2));
        System.out.println(Integer.toBinaryString(l3));

        int n = -178934;
        int n1 = n >>> 3;
        int n2 = n >> 3;
        int n3 = n << 3;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(n1));
        System.out.println(Integer.toBinaryString(n2));
        System.out.println(Integer.toBinaryString(n3));
    }
}
