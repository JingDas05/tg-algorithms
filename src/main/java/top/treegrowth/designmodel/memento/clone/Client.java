package top.treegrowth.designmodel.memento.clone;

import top.treegrowth.designmodel.memento.basic.*;

/**
 * @author wusi
 * @version 2017/7/22 14:38
 */
public class Client {

    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("20170722加班");
        System.out.println("原来的信息" + originator.getState());
        originator.createMemento();
        originator.setState("20170722下班？");
        System.out.println("修改的信息" + originator.getState());
        System.out.println("呵呵，想多了..........");
        originator.restore();
        System.out.println("还原的信息" + originator.getState());
    }
}
