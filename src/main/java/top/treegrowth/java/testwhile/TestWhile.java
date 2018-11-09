package top.treegrowth.java.testwhile;

import java.util.Calendar;
import java.util.Date;

/**
 * @author wusi
 * @version 2018/11/9.
 */
public class TestWhile {

    public static void main(String[] args) {
        int i = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 15);
        System.out.println(calendar.getTimeInMillis());
        System.out.println(new Date().getTime());
        do {
            System.out.println(i++);
        }
        while ((calendar.getTimeInMillis() - new Date().getTime()) < 15 * 1000 && (calendar.getTimeInMillis() - new Date().getTime()) > 0);
    }
}
