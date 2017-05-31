package top.treegrowth.designmodel.state.definedemo;

/**
 *
 * 已售罄状态
 *
 * @author wusi
 * @version 2017/5/31 21:07.
 */
public class SoldOutState implements State{

    private Machine machine;
    //因为要改变当前的状态，machine作为全局context，封装变化，
    // define包里是在State里面setter注入的，这里是构造函数注入的
    public SoldOutState(Machine machine) {
        this.machine = machine;
    }
    @Override
    public void insertMoney() {
        System.out.println("已经卖完了，别投钱了");
    }

    @Override
    public void ejectMoney() {
        System.out.println("已经卖完了，别退币了");
    }

    @Override
    public void turnCrank() {
        System.out.println("已经卖完了，别出货了");
    }

    @Override
    public void dispense() {
        System.out.println("已经卖完了，分配不了了");
    }
}
