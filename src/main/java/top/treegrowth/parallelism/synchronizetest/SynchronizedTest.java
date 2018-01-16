package top.treegrowth.parallelism.synchronizetest;

import java.io.*;

/**
 * @author wusi
 * @version 2017/9/23 16:51.
 */
public class SynchronizedTest {

    public synchronized void method1() {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File("F:\\code\\tg-algorithms\\src\\main\\java\\top\\treegrowth\\parallelism\\test.txt"));
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            for (int i = 1; i < 100000; i++) {
                System.out.println("method11111");
                bufferedOutputStream.write("method11111".getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method2() {
        for (int i = 1; i < 100000; i++) {
            System.out.println("method22222");
        }
    }
}
