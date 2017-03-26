package top.treegrowth.designmodel.mediator;

/**
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
