package top.treegrowth.java8.sort;

import java.util.Date;

/**
 * @author wusi
 * @version 2018/12/6.
 */
public class Item implements Comparable<Item> {

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(Item o) {

        return this.getDate().before(o.getDate()) ? -1 : 1;
    }
}
