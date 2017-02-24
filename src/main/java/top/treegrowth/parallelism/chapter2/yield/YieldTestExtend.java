package top.treegrowth.parallelism.chapter2.yield;

/**
 * @author wusi
 * @version 2017/2/21 22:24.
 */
public class YieldTestExtend extends Thread {

    public YieldTestExtend(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            //出乎意料，这个应该到30的时候从小五变成大武，或者大武变成小五
            //但是前30条就是穿插的了，应为没有锁，会你执行一下，我执行 一下
            System.out.println(this.getName() + "************" + i);
            if (i == 30) {
                this.yield();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new YieldTestExtend("小五");
        Thread thread1 = new YieldTestExtend("大武");
        thread.start();
        thread1.start();
    }
}
