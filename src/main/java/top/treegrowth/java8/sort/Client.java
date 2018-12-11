package top.treegrowth.java8.sort;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wusi
 * @version 2018/12/6.
 */
public class Client {

    public static void main(String[] args) {
        Date currentDate = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(currentDate);
        instance.add(Calendar.SECOND, 10000);

        Item item1 = new Item();
        item1.setDate(currentDate);

        Item item2 = new Item();
        item2.setDate(instance.getTime());

        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        List<Item> collect = list.stream().sorted().collect(Collectors.toList());
        System.out.println(collect.toArray());
    }
}
