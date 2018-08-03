package top.treegrowth.java.userhome;

/**
 * @author wusi
 * @version 2018/8/3.
 */
public class Client {

    public static void main(String[] args) {
        System.setProperty("usr.home", "D:\\wusi");
        System.out.println(System.getProperty("usr.home"));
    }
}
