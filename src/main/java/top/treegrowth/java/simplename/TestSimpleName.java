package top.treegrowth.java.simplename;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wusi
 * @version 2017/7/8 9:52.
 */
public class TestSimpleName {

    @Test
    public void testGetSimpleName() {
        Assert.assertEquals("TestSimpleName",TestSimpleName.class.getSimpleName());
    }
}
