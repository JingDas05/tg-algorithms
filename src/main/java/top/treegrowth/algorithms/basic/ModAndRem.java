package top.treegrowth.algorithms.basic;

/**
 * 取模与取余
 *
 * @author wusi
 * @version 2017/5/16 7:09.
 */
public class ModAndRem {

    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        System.out.println(5 % 3);

        a = -5;
        b = 3;
        System.out.println(a % b);

        a = 5;
        b = -3;
        System.out.println(a % b);

        a = -5;
        b = -3;
        System.out.println(a % b);

        a = 5;
        double c = 3.3;
        System.out.println(a % c);

        a = -7;
        b = 4;
        System.out.println(a % b);
        System.out.println(Math.floorMod(a, b));

        a = 2;
        b = 5;
        System.out.println(a % b);
        System.out.println(a / b);
    }
}
