package top.treegrowth.designmodel.specification;

import top.treegrowth.designmodel.specification.define.CompositeSpecification;
import top.treegrowth.designmodel.specification.model.AbstractModel;

/**
 * @author wusi
 * @version 2017/2/23 17:41
 */
public class BzEqualSpecification extends CompositeSpecification {

    private AbstractModel condition;

    public BzEqualSpecification(AbstractModel condition) {
        this.condition = condition;
    }

    @Override
    public boolean isSatisfiedBy(AbstractModel condition) {
        return condition.getName().equals(this.condition.getName());
    }
}
