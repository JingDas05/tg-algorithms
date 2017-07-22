package top.treegrowth.designmodel.memento.basic;

/**
 * 原信息对象
 *
 * @author wusi
 * @version 2017/7/22 14:03
 */
public class Originator {

    private String state = "";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(this.state);
    }

    public void restore(Memento _memento) {
        this.setState(_memento.getState());
    }
}
