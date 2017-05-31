package top.treegrowth.designmodel.state.definedemo;

/**
 * 售卖机，充当状态模式中的context
 *
 * @author wusi
 * @version 2017/5/31 21:04.
 */
public class Machine {

    //机器可以改变当前状态，所以作为全局context,machine中应该四种状态的引用
    // 这样各个状态就可以直接使用，提供getter方法，不提供setter方法
    private State hasMoneyState;
    private State noMoneyState;
    private State soldState;
    private State soldOutState;
    //当前machine状态，提供setter和getter方法,初始化为已售罄状态
    private State currentState = soldState;
    //当前商品的数量
    private int count;

    //类初始化时，同时初始化状态，使machine达到可以使用的状态
    public Machine(int count) {
        hasMoneyState = new HasMoneyState(this);
        noMoneyState = new NoMoneyState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        this.count = count;
        if (this.count >0) {
            this.currentState = noMoneyState;
        }
    }

    //各个操作，具体的实现是当前的状态执行具体的方法
    public void insertMoney() {
        this.currentState.insertMoney();
    }
    public void ejectMoney() {
        this.currentState.ejectMoney();
    }
    public void turnCrank() {
        this.currentState.turnCrank();
        this.currentState.dispense();
    }
    public void dispense() {
         System.out.println("");
         if (this.count != 0) {
             this.count -= 1;
         }
    }

    //各个状态的getter方法
    public State getHasMoneyState() {
        return hasMoneyState;
    }

    public State getNoMoneyState() {
        return noMoneyState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    //currentState 当前状态的getter 和 setter
    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getCount() {
        return count;
    }

    public void refill(int count) {
        this.count = count;
        if (count > 0) {
            currentState = noMoneyState;
        }
    }
}
