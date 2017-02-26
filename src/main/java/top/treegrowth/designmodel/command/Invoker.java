package top.treegrowth.designmodel.command;

/**
 * 命令可以通过构造器注入，或者set注入进来
 *
 * @author wusi
 * @version 2017/2/26 20:57.
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }

}
