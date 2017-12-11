package top.treegrowth.java.classinit.basic;

/**
 * @author wusi
 * @version 2017/12/3 21:45.
 */
public class Base {

    public String baseName = "父类baseName";
    public static String baseStaticName = "父类baseStaticName";

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类代码块");
    }

    public Base() {
        System.out.println("父类构造函数");
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }
}
