package top.treegrowth.designmodel.mediator;

/**
 *
 *
 * 单一职责原则
 * 依赖倒置原则
 * 接口隔离原则
 * 迪米特原则
 * 里氏替换原则
 * 开闭原则
 *
 * @author wusi
 * @version 2017/3/26 21:50.
 */
public class Client {

    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        ConcreteColleague1 concreteColleague1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 concreteColleague2 = new ConcreteColleague2(mediator);
        mediator.setConcreteColleague1(concreteColleague1);
        mediator.setConcreteColleague2(concreteColleague2);

        concreteColleague1.dependenceMethod();
        concreteColleague2.dependenceMethod();
    }
}
