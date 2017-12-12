package top.treegrowth.java.classinit.stockandconstruct;

/**
 *
 * 这段代码说明了，先初始化成员变量和代码块，之后再初始化构造函数
 *
 * @author wusi
 * @version 2017/12/12 17:10
 */
public class StockAndConstructTest {

    private String name;

    public StockAndConstructTest() {
        System.out.println("打印名字");
        System.out.println(name);
    }

    {
        name = "代码块初始字段";
    }

    public static void main(String[] args) {
        new StockAndConstructTest();
    }
}
