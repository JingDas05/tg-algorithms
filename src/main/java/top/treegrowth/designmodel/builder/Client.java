package top.treegrowth.designmodel.builder;

/**
 * @author wusi
 * @version 2017/7/15 14:55
 */
public class Client {

    public static void main(String[] args) {
        Director director = new Director();
        director.getProduct().doSomething();
    }
}
