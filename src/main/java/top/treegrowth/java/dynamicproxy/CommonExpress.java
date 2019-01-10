package top.treegrowth.java.dynamicproxy;

/**
 * @author wusi
 * @version 2019/1/10 22:49.
 */
public class CommonExpress implements Express {

    @Override
    public void receive(String goods) {
        System.out.println("commonExpress" + goods);
    }
}
