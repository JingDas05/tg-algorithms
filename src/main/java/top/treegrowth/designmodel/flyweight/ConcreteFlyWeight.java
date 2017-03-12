package top.treegrowth.designmodel.flyweight;

/**
 * @author wusi
 * @version 2017/3/12 10:25
 */
public class ConcreteFlyWeight extends FlyWeight {

    //调用父类的构造方法，初始化外部状态
    //父类这个字段是protect，表明这个字段是需要继承的，由子类去初始化这个外部状态
    public ConcreteFlyWeight(String extrinsic) {
        super(extrinsic);
    }

    //根据外部状态确定业务逻辑
    @Override
    public void operate() {

    }
}
