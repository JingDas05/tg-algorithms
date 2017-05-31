package top.treegrowth.designmodel.state.define;

/**
 * 定义抽象状态，并且定义抽象方法doSomething1() 和 doSomething2(),子类需要实现
 * 状态改变时，改变的是context中的currentState,并且调用currentState的相应行为
 * 每个状态的行为都是一样的 都是doSomething1 doSomething2等
 *
 * @author wusi
 * @version 2017/5/21 6:43.
 */
public abstract class State {

    // 状态之间相互通信的context,定义这个是封装状态的变化引起的功能变化
    protected Context context;

    // 由于子类都用这个方法，故写到抽象类中
    public void setContext(Context context) {
        this.context = context;
    }

    protected abstract void doSomething1();

    protected abstract void doSomething2();

}
