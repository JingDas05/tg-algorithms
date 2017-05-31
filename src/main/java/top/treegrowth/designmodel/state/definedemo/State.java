package top.treegrowth.designmodel.state.definedemo;

/**
 * 贩卖机
 *
 * @author wusi
 * @version 2017/5/31 21:01.
 */
public interface State {

    //投币
    void insertMoney();
    //退币
    void ejectMoney();
    //出货
    void turnCrank();
    //分发
    void dispense();
}
