package top.treegrowth.concurrent.volatiletest;

import org.springframework.stereotype.Component;

/**
 * @author wusi
 * @version 2018/8/6.
 */
@Component
public class VolatileTest {

    private volatile Integer sharedValue = 0;
    private Integer normalValue = 0;

    public void start() {
        new Thread(new Modify()).start();
        new Thread(new Read()).start();
    }

    public class Modify implements Runnable {
        @Override
        public synchronized void run() {
            while (true) {
                normalValue++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public class Read implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println(normalValue);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
