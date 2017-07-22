package top.treegrowth.designmodel.memento.basic;

/**
 *
 * 备忘录对象，这个地方存储了需要备份的状态
 *
 * @author wusi
 * @version 2017/7/22 14:04
 */
public class Memento {

    private String state = "";

    public Memento(String _state) {
        this.state = _state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
