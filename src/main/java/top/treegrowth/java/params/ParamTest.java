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
}
