package top.treegrowth.java.string;

import java.util.UUID;

/**
 * @author wusi
 * @since 2019-09-27 15:22
 */
public class UUIDTest {

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }
}
