package top.treegrowth.java.classinit.table;

/**
 * @author wusi
 * @version 2017/12/4 6:47.
 */
public class Client {

    public static void main(String[] args) {
        new Cupboard();
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}
