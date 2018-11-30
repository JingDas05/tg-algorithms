package top.treegrowth.java.extend.parent;

/**
 * @author wusi
 * @version 2018/11/27.
 */
public class Client {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Son son1 = new Son();
        son1.setName("1");

        Son son2 = new Son();
        son2.setName("2");
        System.out.println(son1.getName());

    }
}
