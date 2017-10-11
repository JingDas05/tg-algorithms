package top.treegrowth.java.params;

/**
 * @author wusi
 * @version 2017/10/11 8:54
 */
public class ParamTest {

    public static void main(String[] args) {
        ParamTest paramTest = new ParamTest();
        // 测试值传递
        int a = 0;
        paramTest.testIntA(0);
        System.out.println(a);
        // 引用调用
        String b = "str_old";
        paramTest.testStringB(b);
        System.out.println(b);

        StringBuffer c = new StringBuffer("buffer_old");
        paramTest.testStringBufferC(c);
        System.out.println(c);

        String d = new String("str_old");
        paramTest.testStringObjectD(d);
        System.out.println(d);

        // 最终级别
        StringBuffer e = new StringBuffer("e");
        StringBuffer f = new StringBuffer("f");
        paramTest.changeStringBufferEAndF(e, f);
        System.out.println(e);
        System.out.println(f);
    }

    // 这个地方的a是形参
    public void testIntA(int a) {
        a += 1;
        System.out.println(a);
    }

    public void testStringB(String b) {
        b = "str_new";
        System.out.println(b);
    }

    public void testStringBufferC(StringBuffer c) {
        c = c.append("buffer_new");
        System.out.println(c);
    }

    public void testStringObjectD(String d) {
        d = new String("str_object_new");
        System.out.println(d);
    }

    // 传递了两个地址 e, f, 地址是按值传递的
    public void changeStringBufferEAndF(StringBuffer e, StringBuffer f) {
        // 这个地方会修改e所指向的字符串的值，因此会修改实参e的值
        e.append("add");
        // 这个地方居然没有改变f，蒙圈
        // 执行这个地方的时候，是引用传递的 “值传递”，只会修改形参的地址，不会修改实参，也就是不会修改外面传入的f
        f = e;
        System.out.println(f);
    }
}
