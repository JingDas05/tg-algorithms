package top.treegrowth.designmodel.memento.basic;

import java.util.HashMap;

/**
 * 管理备忘录的守护者，这个守护者封装了备忘录的状态
 * 抽象了备忘录的操作
 *
 * @author wusi
 * @version 2017/7/22 14:09
 */
public class Caretaker {

    //备忘录对象集合
    private HashMap<String, Memento> mementos = new HashMap<>();

    public Memento getMemento(String id) {
        return mementos.get(id);
    }

    public void setMemento(String id, Memento memento) {
        this.mementos.put(id, memento);
    }
}
