package top.treegrowth.java.longtest;

/**
 * @author wusi
 * @since 2019-07-22 15:24
 */
public class LongSpiltTest {

    public static void main(String[] args) {
        System.out.println(fenToYuan("10000"));
        System.out.println(fenToYuan("10010"));
        System.out.println(fenToYuan("19876"));
    }

    private static String fenToYuan(String price) {
        if (price.endsWith("00")) {
            return String.format("%.0f", new Double(price)/100);
        }
        if (price.endsWith("0")) {
            return String.format("%.1f", new Double(price)/100);
        }
        return String.format("%.2f", new Double(price) / 100);
    }
}
