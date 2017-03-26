package top.treegrowth.designmodel.mediator;

/**
 * @author wusi
 * @version 2017/3/26 21:41.
 */
public class ConcreteColleague2 extends Colleague{

    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void selfMethod1() {
        System.out.println("同事类2执行自己的方法1");
    }

    public void selfMethod2() {
        System.out.println("同事类2执行自己的方法2");
    }

    //自己不能完成的调用中介者的方法
    public void dependenceMethod() {
        super.mediator.doSomething1();
    }
}
