package top.treegrowth.designmodel.flyweight;

/**
 * @author wusi
 * @version 2017/3/12 10:20
 */
public abstract class FlyWeight {

    //定义内部状态
    private String intrinsic;
    //定义外部状态,通过继承实现
    protected final String extrinsic;

    public FlyWeight(String extrinsic) {
        this.extrinsic = extrinsic;
    }

    //根据外部状态实现自己的逻辑
    public abstract void operate();

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}
