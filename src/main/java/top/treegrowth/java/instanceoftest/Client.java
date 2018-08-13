package top.treegrowth.java.instanceoftest;

/**
 * @author wusi
 * @version 2018/8/10.
 */
public class Client {
    private  static  InterfaceImpl anInterface = new InterfaceImpl();
    public static void main(String[] args) {

        System.out.println(anInterface instanceof Interface);
    }
}
