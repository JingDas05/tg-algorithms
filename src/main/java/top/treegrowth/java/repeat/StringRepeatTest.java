package top.treegrowth.java.repeat;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wusi
 * @version 2019/1/4 11:19.
 */
public class StringRepeatTest {

    public static void main(String[] args) {
        Set<Character> words = new HashSet<>();
        String content = "sdsfsxdfsdfsdfsdfsdfuiwerwd";
        Integer length = content.length();
        for (int i = 0; i < length; i++) {
            boolean addSuccess = words.add(content.charAt(i));
            if (!addSuccess) {
                System.out.println(content.charAt(i));
                break;
            }
        }
    }
}
