package top.treegrowth.java.isint;

import java.util.regex.Pattern;

/**
 * @author Administrator
 */
public class TestInget {

    public static void main(String[] args) {
        System.out.println(isInteger("12543"));
        System.out.println("12 361".replace(" ", "").length());
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
