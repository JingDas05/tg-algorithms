package top.treegrowth.designmodel.state.demo1;

/**
 * @author wusi
 * @version 2017/5/21 19:52.
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        State state1 = new ConcreteState1();
        context.setCurrentState(state1);
        context.doSomething1();
        context.doSomething2();

    }
}
