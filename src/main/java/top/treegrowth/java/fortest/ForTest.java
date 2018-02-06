package top.treegrowth.java.fortest;

/**
 * @author wusi
 * @version 2018/2/6 17:38
 */
public class ForTest {

    public static void main(String[] args) {
        for (int binCount = 0; ; ++binCount) {
            System.out.println(binCount);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
