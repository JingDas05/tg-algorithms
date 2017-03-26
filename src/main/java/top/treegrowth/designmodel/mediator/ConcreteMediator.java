package top.treegrowth.designmodel.mediator;

/**
 * @author wusi
 * @version 2017/3/26 21:46.
 */
public class ConcreteMediator extends Mediator {
    @Override
    protected void doSomething1() {
        super.concreteColleague1.selfMethod1();
        super.concreteColleague2.selfMethod1();
    }

    @Override
    protected void doSomething2() {
        super.concreteColleague1.selfMethod2();
        super.concreteColleague2.selfMethod2();
    }
}
