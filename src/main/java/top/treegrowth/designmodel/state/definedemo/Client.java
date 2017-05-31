package top.treegrowth.designmodel.state.definedemo;

/**
 *
 * 顾客
 *
 * @author wusi
 * @version 2017/5/31 21:08.
 */
public class Client {

    public static void main(String[] args) {
        Machine machine = new Machine(9);
        State noMoneyState = new NoMoneyState(machine);
        noMoneyState.insertMoney();
    }
}
