package top.treegrowth.java;

import org.apache.commons.lang.StringUtils;

/**
 * @author wusi
 * @version 2017/7/13 14:50
 */
public class UUID {

    public static void main(String[] args) {
        System.out.println(getUUID());
    }

    public static String getUUID() {
        return StringUtils.replace(java.util.UUID.randomUUID().toString(), "-",
                "");
    }
}
