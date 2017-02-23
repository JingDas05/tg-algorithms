package top.treegrowth.designmodel.bridge;

/**
 * @author wusi
 * @version 2017/2/23 13:52
 */
public class Client {


    public static void main(String[] args) {
        Implement a = new ConcreteImplA();
        Abstract anAbstract = new RefinedAbstract(a);
        anAbstract.request();
    }
}
