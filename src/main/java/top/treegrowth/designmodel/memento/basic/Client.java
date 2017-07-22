package top.treegrowth.designmodel.memento.basic;

/**
 * 备忘录模式
 * <p>
 * 单一职责原则
 * 依赖倒置原则
 * 接口隔离原则
 * 迪米特原则
 * 里氏替换原则
 * 开闭原则
 *
 * @author wusi
 * @version 2017/7/19 9:15
 */
public class Client {

    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        originator.setState("20170722加班");
        System.out.println("原来的信息" + originator.getState());
        caretaker.setMemento("1", originator.createMemento());
        originator.setState("20170722下班？");
        System.out.println("修改的信息" + originator.getState());
        System.out.println("呵呵，想多了..........");
        originator.restore(caretaker.getMemento("1"));
        System.out.println("还原的信息" + originator.getState());
    }
}
