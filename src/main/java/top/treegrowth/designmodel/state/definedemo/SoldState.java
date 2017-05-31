package top.treegrowth.designmodel.state.definedemo;

/**
 *
 * 正在出售状态
 *
 * @author wusi
 * @version 2017/5/31 21:06.
 */
public class SoldState implements State{

    private Machine machine;
    //因为要改变当前的状态，machine作为全局context，封装变化，
    // define包里是在State里面setter注入的，这里是构造函数注入的
    public SoldState(Machine machine) {
        this.machine = machine;
    }
    @Override
    public void insertMoney() {
        System.out.println("请稍等片刻，正在出货");
    }

    @Override
    public void ejectMoney() {
        System.out.println("对不起，已经出货了");
    }

    @Override
    public void turnCrank() {
        System.out.println("正在出货......");
    }

    @Override
    public void dispense() {
        this.machine.dispense();
        if (machine.getCount() >0 ) {
            machine.setCurrentState(machine.getNoMoneyState());
        }else {
            System.out.println("卖光了");
            machine.setCurrentState(machine.getSoldOutState());
        }

    }
}
