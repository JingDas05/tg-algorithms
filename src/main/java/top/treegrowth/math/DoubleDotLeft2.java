package top.treegrowth.math;

/**
 * @author wusi
 * @since 2019-07-18 20:42
 */
public class DoubleDotLeft2 {

    public static void main(String[] args) {
        String a = "100";
        String b = "2100";
        String c = "10089";
        String d = "50";

        Double ad = new Double(a);
        Double ab = new Double(b);
        Double ac = new Double(c);
        Double ae = new Double(d);

        System.out.println(ad/100);
        System.out.println(ab/100);
        System.out.println(ac/100);
        System.out.println(ae/100);

        System.out.println(String.format("%.2f", ac/100));

    }
}
