package top.treegrowth.java.decimaltest;

import java.math.BigDecimal;

/**
 * @author Administrator
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("10.0");
        System.out.println(bigDecimal.scale());
        System.out.println(bigDecimal.scale());
        if (bigDecimal.scale() > 1
                || bigDecimal.compareTo(UNDER_INSURANCE_COST) < 0
                || bigDecimal.compareTo(UPPER_INSURANCE_COST) >= 0) {
            System.out.println("不合法");
        }else {
            System.out.println("合法");
        }
    }

    private static final BigDecimal UPPER_INSURANCE_COST = new BigDecimal("10.0");
    private static final BigDecimal UNDER_INSURANCE_COST = new BigDecimal("0.0");
}
