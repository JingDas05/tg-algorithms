package top.treegrowth.designmodel.command;

/**
 * receiver 可能有多个
 *
 * @author wusi
 * @version 2017/2/26 21:00.
 */
public class ConcreteCommand2 extends Command{

    public Receiver receiver;

    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.doSomething();
    }
}
