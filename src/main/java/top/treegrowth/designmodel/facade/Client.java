package top.treegrowth.designmodel.facade;

/**
 * @author wusi
 * @version 2017/3/11 20:47.
 */
public class Client {

    static Facade1 facade1 = new Facade1();
    static Facade2 facade2 = new Facade2();

    public static void main(String[] args) {
        facade1.methodB();
        facade2.methodB();
        facade2.methodCWithContext();
    }
}
