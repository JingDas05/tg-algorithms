package top.treegrowth.concurrent.lock;

/**
 * @author wusi
 * @version 2017/12/10 8:12.
 */
public class ReenterNoLockTest {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        ReenterNoLock r2 = new ReenterNoLock();
        Thread t1 = new Thread(r2);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
//      t1.join();
//      t2.join();
        System.out.println("i outer result is :" + r2.getI());
    }
}
