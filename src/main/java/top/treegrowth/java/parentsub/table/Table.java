package top.treegrowth.java.parentsub.table;

/**
 * @author wusi
 * @version 2017/12/3 22:41.
 */
public class Table {

    static Bowl bowl1 = new Bowl(1);

    Table() {
        System.out.println("Table");

    }

    public void f2(int index) {
        System.out.println("f2" + index);
        bowl12.f1(1);
    }

    static Bowl bowl12 = new Bowl(2);
}
