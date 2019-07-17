package top.treegrowth.lock;

public class Client {

    public static void main(String[] args) throws Exception{
        LockManager manager = new LockManager();
//        Lock lock = manager.acquire("key", 5000);
//        System.out.println(lock);
//        Lock lock1 = manager.acquire("key", 5000);
//        System.out.println(lock1);
//        Thread.sleep(6000);
//        Lock lock2 = manager.acquire("key", 5000);
//        System.out.println(lock2);



        Lock lock3 = manager.acquire("key6", 50000);
        System.out.println(lock3);
        boolean result = manager.release(lock3);
        System.out.println(result);
        lock3 = manager.acquire("key6", 50000);
        System.out.println(lock3);

    }
}
