package top.treegrowth.java.classinit.table;

/**
 * @author wusi
 * @version 2017/12/3 23:09.
 */
public class Cupboard {

    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    public Cupboard() {
        System.out.println("Cupboard构造函数");
        bowl4.f1(2);
    }

    public void f3(int index) {
        System.out.println("f3" + index);
    }

    static Bowl bowl5 = new Bowl(5);
}
