package top.treegrowth.designmodel.specification;

import top.treegrowth.designmodel.specification.define.CompositeSpecification;
import top.treegrowth.designmodel.specification.model.AbstractModel;

/**
 * @author wusi
 * @version 2017/2/23 17:44
 */
public class BzLargeSpecification extends CompositeSpecification {

    private AbstractModel condition;

    public BzLargeSpecification(AbstractModel condition) {
        this.condition = condition;
    }

    @Override
    public boolean isSatisfiedBy(AbstractModel condition) {
        return condition.getAge() > this.condition.getAge();
    }
}
