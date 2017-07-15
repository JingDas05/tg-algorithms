package top.treegrowth.designmodel.builder;

/**
 * @author wusi
 * @version 2017/7/15 14:52
 */
public class ConcreteBuilder extends Builder{

    private Product product = new Product();

    //设置产品零件
    @Override
    public void setPart() {
        //产品内部逻辑处理
        System.out.println("产品内部设置零部件");
    }

    // 返回产品实例
    @Override
    public Product buildProduct() {
        return product;
    }
}
