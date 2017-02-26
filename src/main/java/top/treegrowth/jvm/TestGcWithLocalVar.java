package top.treegrowth.jvm;

/**
 * 被局部变量引用的不能被gc
 *
 * @author wusi
 * @version 2017/2/26 8:16.
 */
public class TestGcWithLocalVar {

    public static void main(String[] args) {
        TestGcWithLocalVar testGcWithLocalVar = new TestGcWithLocalVar();
        testGcWithLocalVar.localvarGc1();
    }

    //false gc
    public void localvarGc1() {
        byte[] a = new byte[6 * 1024 * 1024];
        System.gc();
    }

    //true
    public void localvarGc2() {
        byte[] a = new byte[6 * 1024 * 1024];
        a = null;
        System.gc();
    }

    //false
    public void localvarGc3() {
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        System.gc();
    }

    //true
    public void localvarGc4() {
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        int c = 10;
        System.gc();
    }

    //true
    public void localvarGc5() {
        localvarGc1();
        System.gc();
    }

}
