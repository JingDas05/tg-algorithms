package top.treegrowth.java.isntanceoftest;

/**
 * @author wusi
 * @version 2018/1/23 9:42
 */
public class Client {

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        System.out.println(subClass instanceof SubClass);
        System.out.println(subClass instanceof SubClass);
    }
}
