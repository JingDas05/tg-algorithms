package top.treegrowth.designmodel.state.definedemo;

/**
 *
 * 已投币的状态
 *
 * @author wusi
 * @version 2017/5/31 21:04.
 */
public class HasMoneyState implements State{

    private Machine machine;

    //因为要改变当前的状态，machine作为全局context，封装变化，
    // define包里是在State里面setter注入的，这里是构造函数注入的
    public HasMoneyState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void insertMoney() {
        System.out.println("您已经投过币了，请稍后再试");
    }

    @Override
    public void ejectMoney() {
        System.out.println("退币");
        this.machine.setCurrentState(machine.getNoMoneyState());
    }

    @Override
    public void turnCrank() {
        System.out.println("正在出货");
        this.machine.setCurrentState(machine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("没有商品正在分配");
    }
}
