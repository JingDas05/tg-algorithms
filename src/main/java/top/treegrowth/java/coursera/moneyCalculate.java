package top.treegrowth.java.coursera;

/**
 * @author wusi
 * @version 2018/8/6.
 */
public class moneyCalculate {

    public static void main(String[] args) {
        System.out.println(calculate(250D));
        System.out.println(calculate(600D));
        System.out.println(calculate(10000D));
        System.out.println(calculate(400D));
    }

    public static double calculate(double money) {
        return money / 10 * 60 * 4;
    }
}
