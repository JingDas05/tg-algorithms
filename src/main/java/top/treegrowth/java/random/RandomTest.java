package top.treegrowth.java.random;

import java.util.Random;
import java.util.UUID;

/**
 * @author wusi
 * @version 2018/11/14.
 */
public class RandomTest {

    public static void main(String[] args) {
//        Random random = new Random();
//        for (int i = 0; i < 1000; i++) {
//            System.out.println(random.nextInt(99999999));
//        }

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
//            System.out.println(String.format("%02d", random.nextInt(99)));
//            System.out.println(String.format("random is %s", random.nextInt(99)));
            System.out.println(UUID.randomUUID().toString().replace("-",""));

        }
    }
}