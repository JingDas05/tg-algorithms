package top.treegrowth.javasource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wusi
 * @version 2017/3/28 13:11
 */
public class ListCus {

    private static List<String> list;

    public static void main(String[] args) {
        list = new ArrayList<>();
        list.add("测试数据");
        list.size();
        list.clear();
        list.listIterator();
    }
}
