package top.treegrowth.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wusi
 * @version 2017/9/22 11:05
 */
public class TestRegex {

    public static void main(String[] ss) {
        String s = "abc.jpg";
        //String regex=".+?//.(.+)";这种写法也是可以的，但我认为没有后面的精确
        String regex = ".+?//.([a-zA-z]+)";
        Pattern pt = Pattern.compile(regex);
        Matcher mt = pt.matcher(s);
        if (mt.find()) {
            System.out.println(mt.group(1));
        }
    }

}
