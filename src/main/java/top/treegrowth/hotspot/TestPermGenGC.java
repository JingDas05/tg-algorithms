package top.treegrowth.hotspot;

import org.junit.Test;

/**
 *
 * -XX:+PrintGCDetails -XX:PermSize=2M -XX:MaxPermSize=4M
 *
 * @author wusi
 * @version 2017/7/4 21:15.
 */
public class TestPermGenGC {

    @Test
    public void permGenGC() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String t = String.valueOf(i).intern();
        }
    }
}
