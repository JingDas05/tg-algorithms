package top.treegrowth.designmodel.bridge;

/**
 * @author wusi
 * @version 2017/2/23 13:48
 */
public class RefinedAbstract extends Abstract {
    public RefinedAbstract(Implement impl) {
        super(impl);
    }

    @Override
    public void request() {
        //可以做自己的一些事情
        super.request();
    }
}
