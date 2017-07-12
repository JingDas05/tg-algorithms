package top.treegrowth.designmodel.command;

/**
 *
 * 单一职责原则
 * 依赖倒置原则
 * 接口隔离原则
 * 迪米特原则
 * 里氏替换原则
 * 开闭原则
 *
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
