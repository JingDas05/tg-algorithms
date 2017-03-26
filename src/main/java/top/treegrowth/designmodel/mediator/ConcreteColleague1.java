package top.treegrowth.designmodel.mediator;

/**
 * @author wusi
 * @version 2017/3/26 21:40.
 */
public class ConcreteColleague1 extends Colleague {

    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void selfMethod1() {
        System.out.println("同事类1执行自己的方法1");
    }

    public void selfMethod2() {
        System.out.println("同事类1执行自己的方法2");
    }

    //自己不能完成的调用中介者的方法
    public void dependenceMethod() {
        super.mediator.doSomething2();
    }
}
