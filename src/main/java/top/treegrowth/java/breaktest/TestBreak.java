package top.treegrowth.java.breaktest;

import java.util.Scanner;

/**
 * @author wusi
 * @version 2018/3/26 7:56.
 */
public class TestBreak {

    public static void main(String[] params) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入循环次数");
        int n = scanner.nextInt();
        read_data:
        while (n > 1) {
            System.out.printf("当前次数是 %d %n", n);
            if (n < 5) {
                break read_data;
            }
            n--;
        }
        System.out.println("跳出循环了");
    }
}
