package top.treegrowth.designmodel.specification;


import top.treegrowth.designmodel.bridge.Abstract;
import top.treegrowth.designmodel.specification.model.AbstractModel;

/**
 *
 * 单一职责原则
 * 依赖倒置原则
 * 接口隔离原则
 * 迪米特原则
 * 里氏替换原则
 * 开闭原则
 *
 * @author wusi
 * @version 2017/2/23 17:39
 */
public class Client {

    public static void main(String[] args) {
        //初始化condition,这个地方condition 是一个model
        AbstractModel condition = new AbstractModel("wusi", 27);

        //需要搜索的对象
        AbstractModel target = new AbstractModel("wusi", 28);
        testsingleton(target, condition);
        testComposite(target, condition);
    }

    public static void testsingleton(AbstractModel target, AbstractModel condition) {
        if (new BzEqualSpecification(condition).isSatisfiedBy(target)) {
            System.out.println("singleton test success");
        }
    }

    public static void testComposite(AbstractModel target, AbstractModel condition) {
        if (new BzEqualSpecification(condition).or(new BzLargeSpecification(condition)).isSatisfiedBy(target)) {
            System.out.println("composite test success");
        }
    }
}
