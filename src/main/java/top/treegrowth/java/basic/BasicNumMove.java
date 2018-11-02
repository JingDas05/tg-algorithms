package top.treegrowth.java.basic;

/**
 * @author wusi
 * @version 2018/10/19.
 */
public class BasicNumMove {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int COUNT_BITS = Integer.SIZE - 3;
        int CAPACITY = (1 << COUNT_BITS) - 1;

        // runState is stored in the high-order bits
        int RUNNING = -1 << COUNT_BITS;
        final int SHUTDOWN = 0 << COUNT_BITS;
        final int STOP = 1 << COUNT_BITS;
        final int TIDYING = 2 << COUNT_BITS;
        final int TERMINATED = 3 << COUNT_BITS;
    }
}
