package top.treegrowth.java;

import java.math.BigDecimal;

/**
 * 计算工具类
 *
 * @author wusi
 */
public class GisUtil {


    public static void main(String[] args) {
        System.out.println(calculateDistance(11.11, 12.36, 11.11, 12.35));
    }


    private static final int MULTIPLE = 1000000;

    public GisUtil() {
    }

    public static double convertOriginalCoordinate(Integer lngOrLat) {
        return (new BigDecimal(lngOrLat.intValue())).divide(new BigDecimal(1000000)).doubleValue();
    }

    public static int convertIntegerCoordinate(Double lngOrLat) {
        return (new BigDecimal(lngOrLat.toString())).multiply(new BigDecimal(1000000)).intValue();
    }

    // 计算直线距离,返回的数值单位为米
    public static int calculateDistance(double lat1, double lng1, double lat2, double lng2) {
        // 角度转弧度
        double pointA = lat1 * 3.141592653589793D / 180.0D - lat2 * 3.141592653589793D / 180.0D;
        double pointB = lng1 * 3.141592653589793D / 180.0D - lng2 * 3.141592653589793D / 180.0D;

        double distance = 2.0D * Math.asin(
                Math.sqrt(Math.pow(Math.sin(pointA / 2.0D), 2.0D) + Math.cos(lat1 * 3.141592653589793D / 180.0D) * Math.cos(lat2 * 3.141592653589793D / 180.0D) * Math.pow(Math.sin(pointB / 2.0D), 2.0D)));
        distance = distance * 6378.137D * 1000.0D;
        return (int) distance;
    }

    public static int calculateDistance(int lat1, int lng1, int lat2, int lng2) {
        return calculateDistance((double) lat1 / 1000000.0D, (double) lng1 / 1000000.0D, (double) lat2 / 1000000.0D, (double) lng2 / 1000000.0D);
    }

    public static boolean isNullCoordinate(Integer lngOrLat) {
        return lngOrLat == null || lngOrLat.intValue() == 0;
    }
}