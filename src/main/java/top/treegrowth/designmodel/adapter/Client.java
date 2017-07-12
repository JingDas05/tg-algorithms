package top.treegrowth.designmodel.adapter;

/**
 *
 * 程序设计原则
 *
 * 单一职责原则
 * 依赖倒置原则
 * 接口隔离原则
 * 迪米特原则
 * 里氏替换原则
 * 开闭原则
 *
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
