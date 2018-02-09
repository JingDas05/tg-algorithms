package top.treegrowth.java.equals;

/**
 * 连等赋值后，所有的值都指向最后的值
 *
 * @author wusi
 * @version 2018/2/9 9:53
 */
public class EqualsTest2 {

    public static void main(String[] args) {
        System.out.println("赋值前");
        T t1 = new T();
        System.out.println("t1" + t1);
        T t2 = new T();
        System.out.println("t2" + t2);
        System.out.println("赋值后");
        T t3 = t1 = t2;
        System.out.println("t1" + t1);
        System.out.println("t2" + t2);
        System.out.println("t3" + t3);
    }
}
