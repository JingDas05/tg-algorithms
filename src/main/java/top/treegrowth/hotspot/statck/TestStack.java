package top.treegrowth.hotspot.statck;

import org.junit.Test;

/**
 * 测试虚拟机栈的大小设定
 * 如果线程在计算过程中，请求的栈深度大于最大可用的栈深度，则抛出 {@link StackOverflowError}
 * 如果java栈可以动态拓展，而在拓展栈的过程中，没有足够的内存空间来支持栈的拓展，则抛出 {@link OutOfMemoryError}
 *
 * @author wusi
 * @version 2017/7/4 6:17.
 */
public class TestStack {

    private int count = 0;

    public void recursion() {
        count++;
        recursion();
    }

    // 修改Vm options 参数 -Xss1m可以修改栈深度
    @Test
    public void testStack() {
        try {
            recursion();
        } catch (Throwable e) {
            System.out.println("栈深度为" + count);
            e.printStackTrace();
        }
    }
}
