package top.treegrowth.java.rmi;

import java.io.Serializable;

/**
 * @author wusi
 * @version 2017/7/1 20:48.
 */
public class Order implements Serializable{
    private static final long serialVersionUID = 2188414361762884713L;
    private int orderId;
    private String clientName;
    private int number;
    private String productName;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
