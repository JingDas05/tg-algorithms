package top.treegrowth.java.valueandreference;

/**
 * @author wusi
 * @version 2017/12/23 17:12.
 */
public class TestValueAndReference {

    public static void change(StringBuffer ss1, StringBuffer ss2) {
        ss1.append("word");
        // 按引用传递，传递的是地址，ss2是上面形参ss2的副本，所以没有修改传递进来的实参s2没有影响
        ss2 = ss1;
    }

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = a;
        // 基本类型的包装类型都是不可变类，所以执行b++已经是新建的对象了
        b++;
        System.out.println(a);
        System.out.println(b);

        StringBuffer s1 = new StringBuffer("Hello");
        StringBuffer s2 = new StringBuffer("Hello");
        change(s1, s2);
        System.out.println(s1);
        System.out.println(s2);
    }
}
