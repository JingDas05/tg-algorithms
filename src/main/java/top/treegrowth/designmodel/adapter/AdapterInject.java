package top.treegrowth.designmodel.adapter;


/**
 * 适配器属性通过注入获取
 *
 * @author wusi
 * @version 2017/2/23 14:05
 */
public class AdapterInject implements Target {

    private Adaptee adaptee;

    public AdapterInject(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void getA() {

    }

    @Override
    public void getB() {

    }
}
