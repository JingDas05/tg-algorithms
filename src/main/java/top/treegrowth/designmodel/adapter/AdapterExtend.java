package top.treegrowth.designmodel.adapter;

/**
 * 适配器
 *
 * @author wusi
 * @version 2017/2/23 14:02
 */

public class AdapterExtend extends Adaptee implements Target {

    @Override
    public void getA() {
        getAee();
    }

    @Override
    public void getB() {
        getBee();
    }
}
