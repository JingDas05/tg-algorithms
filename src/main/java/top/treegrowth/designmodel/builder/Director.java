package top.treegrowth.designmodel.builder;

/**
 * @author wusi
 * @version 2017/7/15 14:54
 */
public class Director {

    private Builder builder = new ConcreteBuilder();

    //构建不同的产品
    public Product getProduct() {
        // 主要是这个方法构建不同产品
        builder.setPart();
        return builder.buildProduct();
    }
}
