package top.treegrowth.designmodel.state.definedemo;

/**
 *
 * 未投币的状态
 *
 * @author wusi
 * @version 2017/5/31 21:05.
 */
public class NoMoneyState implements State{

    private Machine machine;

    //因为要改变当前的状态，machine作为全局context，封装变化，
    // define包里是在State里面setter注入的，这里是构造函数注入的
    public NoMoneyState(Machine machine) {
        this.machine = machine;
    }
    @Override
    public void insertMoney() {
        System.out.println("您投币了");
        this.machine.setCurrentState(machine.getHasMoneyState());
    }

    @Override
    public void ejectMoney() {
        System.out.println("你没投币，我咋退");
    }

    @Override
    public void turnCrank() {
        System.out.println("您要想商品，但是没有币");
    }

    @Override
    public void dispense() {
        System.out.println("您得先投币");
    }
}
