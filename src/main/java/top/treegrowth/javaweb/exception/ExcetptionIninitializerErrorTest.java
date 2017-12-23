package top.treegrowth.javaweb.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wusi
 * @version 2017/12/20 7:31.
 */
public class ExcetptionIninitializerErrorTest {

    public static Map m = new HashMap() {
        {
            put("a", "2");
        }
    };

    public static void main(String[] args) {

    }
}
