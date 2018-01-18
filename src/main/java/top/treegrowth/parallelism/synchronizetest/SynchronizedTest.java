package top.treegrowth.parallelism.synchronizetest;

import java.io.*;

/**
 * @author wusi
 * @version 2017/9/23 16:51.
 */
public class SynchronizedTest {

    public synchronized void method1() {
//        FileOutputStream fileOutputStream;
//        BufferedOutputStream bufferedOutputStream;
//        try {
//            fileOutputStream = new FileOutputStream(new File("F:\\code\\tg-algorithms\\src\\main\\java\\top\\treegrowth\\parallelism\\test.txt"));
//            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//            for (int i = 1; i < 100000; i++) {
//                System.out.println("method11111");
//                bufferedOutputStream.write("method11111".getBytes());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        for (int i = 1; i < 100; i++) {
            System.out.println("method11111");
            try {
                Thread.sleep(100);
//                Thread.yield();
            } catch (InterruptedException e) {
                System.out.println("线程1被打断了");
            }
        }
    }

    public synchronized void method2() {
        for (int i = 1; i < 100; i++) {
            System.out.println("method22222");
            try {
                Thread.sleep(100);
//                Thread.yield();
            } catch (InterruptedException e) {
                System.out.println("线程2被打断了");
            }
        }
    }
}
