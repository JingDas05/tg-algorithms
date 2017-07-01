package top.treegrowth.javasource.rmi;

import java.rmi.Naming;

/**
 * java rmi远程调用
 *
 * @author wusi
 * @version 2017/7/1 20:53.
 */
public class Client {
    public static void main(String[] argv) {
        try {
            // 根据名字去找寻远程服务
            IOrderManager orderManager = (IOrderManager) Naming
                    .lookup("OrderManager");

            long begin = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                orderManager.getOrder(i);
            }
            System.out.println("getOrder spend:"
                    + (System.currentTimeMillis() - begin));

            begin = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                orderManager.getClientName(i);
                orderManager.getNumber(i);
                orderManager.getProdName(i);
            }
            System.out.println("3 Method call spend:"
                    + (System.currentTimeMillis() - begin));
            System.out.println(orderManager.getOrder(0).getClientName());
        } catch (Exception e) {
            System.out.println("OrderManager exception: " + e);
        }
    }
}
