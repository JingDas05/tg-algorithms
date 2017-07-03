package top.treegrowth.hotspot.statck;

import org.junit.Test;

/**
 *
 * 虚拟机栈在运行的时候使用一种胶战阵的数据结构保存上下文，在栈帧中存放了
 * 局部变量表，操作数栈，动态连接方法和返回地址等信息，每一个方法的调用都伴随着栈帧
 * 的入栈操作，方法的返回则表示栈帧的出栈操作
 * 如果方法调用的时候，方法的参数和局部变量相对较多，那么栈帧中的局部变量表就会越大
 *
 * @author wusi
 * @version 2017/7/4 6:36.
 */
public class TestStackWithMoreParam {
    private int count = 0;

    public void recursion() {
        int a = 0;
        int b = 1;
        long c = 0, d = 0, e = 6;
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
