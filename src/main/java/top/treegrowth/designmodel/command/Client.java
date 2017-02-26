package top.treegrowth.designmodel.command;

/**
 * @author wusi
 * @version 2017/2/26 20:59.
 */
public class Client {

    public static void main(String[] args) {

        Invoker invoker = new Invoker();

        Receiver receiver1 = new Receiver1();
        Command command = new ConcreteCommand1(receiver1);

        invoker.setCommand(command);
        invoker.action();
    }
}
