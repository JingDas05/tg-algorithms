package top.treegrowth.java.classinit.staticandnormal;

/**
 * 先初始化静态变量，后初始化静态代码块，与顺序无关
 *
 * @author wusi
 * @version 2017/12/12 7:28.
 */
public class StaticVariable {


    private String second = "second";

    {
        System.out.print(second);
        System.out.print(first);
    }

    public static String first = "first";

    static {
        System.out.print(first);
    }
}
