package top.treegrowth.java.parentsub.basic;

/**
 * @author wusi
 * @version 2017/12/3 21:48.
 */
public class Sub extends Base {

    public String baseName = "子类普通baseName";
    public static String baseStaticName = "子类静态baseStaticName";

    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类代码块");
    }

    Window before = new Window("父类构造前");

    public Sub() {
        System.out.println("子类构造函数");
    }

    // 此处说明先初始化成员变量，之后是构造函数
    Window after = new Window("父类构造后");

    public void callName() {
        System.out.println(baseName);
    }

    public static void main(String[] args) {
        // 注意 callName()方法调用结果为null
        // 父类构造方法调用callName()时，打印的其实是子类的 baseName，这个时候子类的变量baseName还没有初始化，所以
        // 打印为 null
        Base base = new Sub();
    }
}
