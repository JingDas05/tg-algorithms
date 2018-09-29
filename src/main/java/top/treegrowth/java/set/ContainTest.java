package top.treegrowth.java.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wusi
 * @version 2018/9/28.
 */
public class ContainTest {

    private static final String NATION = "0";

    public static void main(String[] args) {
        System.out.println(isCityEnable(0));
    }

    public static boolean isCityEnable(Integer cityId) {
        Set<String> cityIds = new HashSet<>();
        cityIds.add("0");
        cityIds.add("2");
        return cityIds.contains(String.valueOf(cityId)) || cityIds.contains(NATION);
    }
}
