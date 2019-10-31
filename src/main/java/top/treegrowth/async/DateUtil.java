package top.treegrowth.async;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wusi
 * @since 2019-10-31 08:30
 */
public final class DateUtil {

    //返回当前时间
    public static String getNowTimeString() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }

    //设置日期格式
    public static String getNowDayString() {
        SimpleDateFormat dfday = new SimpleDateFormat("yyyy-MM-dd");
        String nowday = dfday.format(new Date());
        return nowday;
    }
}