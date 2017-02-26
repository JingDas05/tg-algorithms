package top.treegrowth.designmodel.command;

/**
 * receiver 可能有多个
 *
 * @author wusi
 * @version 2017/2/26 20:55.
 */
public class ConcreteCommand1 extends Command {

    public Receiver receiver;

    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //具体的事情逻辑
        receiver.doSomething();
    }
}
