package top.treegrowth.jvm;

/**
 * 需要在启动的时候设置-Xss128k 等参数
 * @author wusi
 * @version 2017/2/26 7:32.
 */
public class TestStackDeep {

    private static int count = 0;

    public static void recursion() {
        count++;
        recursion();
    }

    public static void main(String[] args) {
        try {
            recursion();
        } catch (Throwable t) {
            System.out.println("deep of calling = " + count);
            t.printStackTrace();
        }
    }
}
