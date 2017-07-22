package top.treegrowth.designmodel.memento.clone;

import top.treegrowth.designmodel.memento.basic.Memento;

/**
 *
 * 源信息对象,这个的设计是在原对象信息里保存了另一个源对象信息的引用
 * 当备份或者还原的时候操作这个源对象信息
 *
 * @author wusi
 * @version 2017/7/22 14:03
 */
public class Originator implements Cloneable {

    private Originator backup;

    private String state = "";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void createMemento() {
        this.backup = this.clone();
    }

    public void restore() {
        this.setState(this.backup.getState());
    }

    // 这个地方也可以写成 Memento，内置类
    @Override
    protected Originator clone() {
        try {
            return (Originator) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
