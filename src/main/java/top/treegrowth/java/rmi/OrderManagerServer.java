package top.treegrowth.java.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @author wusi
 * @version 2017/7/1 20:51.
 */
public class OrderManagerServer {
    public static void main(String[] argv) {
        try {
            LocateRegistry.createRegistry(1099);
            IOrderManager orderManager = new OrderManager();
            Naming.rebind("OrderManager", orderManager);
            System.out.println("OrderManager is ready.");
        } catch (Exception e) {
            System.out.println("OrderManager Server failed: " + e);
        }
    }
}
