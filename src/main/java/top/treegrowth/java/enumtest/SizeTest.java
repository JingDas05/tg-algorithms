package top.treegrowth.java.enumtest;

import java.util.Arrays;

/**
 * @author wusi
 * @version 2018/4/22 21:19.
 */
public class SizeTest {

    public static void main(String[] args) {
        System.out.println(Size.MIDDLE.ordinal());
        System.out.println(Arrays.toString(Size.values()));
        System.out.println(Enum.valueOf(Size.class,"MIDDLE"));
    }
}
