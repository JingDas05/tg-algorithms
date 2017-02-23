package top.treegrowth.designmodel.adapter;

/**
 * @author wusi
 * @version 2017/2/23 14:00
 */
public class Client {

    public static void main(String[] args) {
        //创建要适配对象
        Adaptee adaptee = new Adaptee();
        //创建适配器
        AdapterExtend adapterExtend = new AdapterExtend();
        adapterExtend.getA();
        adapterExtend.getB();
        //创建注入适配器
        AdapterInject adapterInject = new AdapterInject(adaptee);
        adapterInject.getA();
        adapterInject.getB();
    }
}
