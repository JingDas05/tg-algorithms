package top.treegrowth.javasource;

/**
 * @author wusi
 * @version 2017/3/29 14:46
 */
public class JavaBasic {

    public static void main(String[] args) {
        Long x = 42L;
        Long y = 44L;
        System.out.print("_" + x + y + "_");
        System.out.print(x + y + "_");
        System.out.print("_" + x + y);
        System.out.println("_" + (x > y ? x : y));

        X x1 = new X();
        X x2 = new Y();
        Y y1 = new Y();

//        x2.do2();
//        (Y) x2.do2();
        ((Y) x2).do2();
    }

    static class X {
        void do1() {
        }
    }

    static class Y extends X {
        void do2() {
        }
    }
}
