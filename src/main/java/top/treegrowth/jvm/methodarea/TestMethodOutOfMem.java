package top.treegrowth.jvm.methodarea;

/**
 * @author wusi
 * @version 2017/2/26 22:47.
 */
public class TestMethodOutOfMem {

    public static void main(String[] args) {
        int i =0;
        for (i =0; i< 100000; i++) {
        }
    }
}
