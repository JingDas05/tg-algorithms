package top.treegrowth.designmodel.strategy;

/**
 * @author wusi
 * @version 2017/2/27 9:38
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new ConcereteStrategy1());
        context.exec();
    }
}
