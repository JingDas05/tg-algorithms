package top.treegrowth.parallelism.lock;

/**
 * @author wusi
 * @version 2017/12/10 8:06.
 */
public class ReentrantLockTest {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        ReenterLock rl = new ReenterLock();
        Thread t1 = new Thread(rl);
        Thread t2 = new Thread(rl);
        t1.start();
        t2.start();
//      t1.join();
//      t2.join();
        System.out.println("i outer result is :" + rl.getI());
    }
}
