package top.treegrowth.lock;

public class Client {

    public static void main(String[] args) throws Exception{
        Lock lock = LockManager.acquire("key", 5000);
        System.out.println(lock);
        Lock lock1 = LockManager.acquire("key", 5000);
        System.out.println(lock1);
        Thread.sleep(6000);
        Lock lock2 = LockManager.acquire("key", 5000);
        System.out.println(lock2);



//        Lock lock3 = LockManager.acquire("key6", 50000);
//        System.out.println(lock3);
//        boolean result = LockManager.release(lock3);
//        System.out.println(result);
//        lock3 = LockManager.acquire("key6", 50000);
//        System.out.println(lock3);

    }
}
