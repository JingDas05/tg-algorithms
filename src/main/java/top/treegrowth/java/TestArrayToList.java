package top.treegrowth.java;

import java.util.Arrays;
import java.util.List;

/**
 * @author wusi
 * @version 2017/8/11 10:43
 */
public class TestArrayToList {
    private static String source = "1,2";

    public static void main(String[] args) {
        String[] array = source.split(",");
        List<String> modifyList = Arrays.asList(array);
        modifyList.add("3");
    }
}
