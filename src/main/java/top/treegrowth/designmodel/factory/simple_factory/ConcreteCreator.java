package top.treegrowth.designmodel.factory.simple_factory;

/**
 * @author wusi
 * @version 2017/6/27 14:03
 */

public class ConcreteCreator extends Creator {
    @SuppressWarnings("unchecked")
    @Override
    public <T extends Product> T createProduct(Class<T> clazz) {
        Product product = null;
        try {
            product = (Product) Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
