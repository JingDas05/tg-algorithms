package top.treegrowth.parallelism.synchronizetest;

/**
 * @author wusi
 * @version 2017/9/23 16:51.
 */
public class SynchronizedTest {

    public synchronized void method1() {
        for (int i = 1; i <10000;i++) {
            System.out.println("method11111");
        }
    }

    public synchronized void method2() {
        for (int i = 1; i <10000;i++) {
            System.out.println("method22222");
        }
    }
}
