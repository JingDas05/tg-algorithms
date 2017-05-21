package top.treegrowth.designmodel.state.demo1;

/**
 * @author wusi
 * @version 2017/5/21 6:47.
 */
public class Context {

    public static State STATE1 = new ConcreteState1();
    public static State STATE2 = new ConcreteState2();

    private State currentState;

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        //state需要用到context
        this.currentState.setContext(this);
    }

    //行为委托
    public void doSomething1() {
        this.currentState.doSomething1();
    }
    public void doSomething2() {
        this.currentState.doSomething2();
    }
}
