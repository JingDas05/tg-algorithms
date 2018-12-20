package top.treegrowth.java.numformat;

import java.text.NumberFormat;

/**
 * @author wusi
 * @version 2018/12/19.
 */
public class NumberFormatTest {

    public static void main(String[] args) {
        System.out.println(offset2FileName(12344545566L));
    }

    public static String offset2FileName(final long offset) {
        final NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(20);
        nf.setMaximumFractionDigits(0);
        nf.setGroupingUsed(false);
        return nf.format(offset);
    }
}
