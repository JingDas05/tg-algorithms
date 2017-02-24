package top.treegrowth.parallelism.chapter2.yield;

/**
 * @author wusi
 * @version 2017/2/22 6:52.
 */
public class YieldTestImpl {

    public static class ThreadImpl implements Runnable {

        private String name;
        private int i;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public ThreadImpl(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                //出乎意料，这个应该到30的时候从小五变成大武，或者大武变成小五
                //但是前30条就是穿插的了，应为没有锁，会你执行一下，我执行 一下
                System.out.println(this.getName() + "************" + i);
            }
        }
    }

    public static void main(String[] args) {
        ThreadImpl runnable1 = new ThreadImpl("小五");
        ThreadImpl runnable2 = new ThreadImpl("大武");
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        if (runnable1.getI() == 30) {
            Thread.yield();
        }
        thread2.start();
    }
}
