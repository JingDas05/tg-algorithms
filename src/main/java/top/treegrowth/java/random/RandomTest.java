package top.treegrowth.java.random;

import java.util.Random;

/**
 * @author wusi
 * @version 2018/11/14.
 */
public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            System.out.println(random.nextInt(99999999));
        }
    }
}