package top.treegrowth.designmodel.memento.clone;

import top.treegrowth.designmodel.memento.basic.Memento;

/**
 * 管理备忘录的守护者，这个守护者封装了备忘录的状态
 * 在clone模式下，源信息既是源信息对象又是备份对象
 *
 * @author wusi
 * @version 2017/7/22 14:09
 */
public class Caretaker {

    //备忘录对象
    private Originator originator;

    public Originator getOriginator() {
        return originator;
    }

    public void setOriginator(Originator originator) {
        this.originator = originator;
    }
}
