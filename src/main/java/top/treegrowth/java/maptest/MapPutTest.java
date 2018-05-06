package top.treegrowth.java.maptest;

import sun.awt.SunHints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public class MapPutTest {

    public static void main(String[] args) {
        Map<Byte, Value> map = new HashMap<>();
        Value value = map.get((byte) 1);
        System.out.println(value);
        if (value == null) {
            value = new Value("1");
        }
        System.out.println(map.values().toArray());
    }
}
