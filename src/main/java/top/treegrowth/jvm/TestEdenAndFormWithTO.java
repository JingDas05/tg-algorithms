package top.treegrowth.jvm;

/**
 * @author wusi
 * @version 2017/2/27 7:35.
 */
public class TestEdenAndFormWithTO {

    public static void main(String[] args) {
        byte[] b = null;
        for (int i = 0; i < 10; i++) {
            b = new byte[10 * 1024 * 1024];
        }
    }
}
