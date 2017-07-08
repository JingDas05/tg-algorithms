package top.treegrowth.java.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author wusi
 * @version 2017/7/1 20:50.
 */
public interface IOrderManager extends Remote{

    Order getOrder(int id) throws RemoteException;
    String getClientName(int id) throws RemoteException;
    String getProdName(int id) throws RemoteException;
    int getNumber(int id) throws RemoteException;
}
