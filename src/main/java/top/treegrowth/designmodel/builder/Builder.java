package top.treegrowth.designmodel.builder;

/**
 * @author wusi
 * @version 2017/7/15 14:51
 */
public abstract class Builder {

    // 生产产品时，设置各个部分，以获得不同的产品
    public abstract void setPart();

    //生产产品
    public abstract Product buildProduct();
}
