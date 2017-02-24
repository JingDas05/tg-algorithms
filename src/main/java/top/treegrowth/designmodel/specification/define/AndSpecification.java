package top.treegrowth.designmodel.specification.define;

import top.treegrowth.designmodel.specification.model.AbstractModel;

/**
 * @author wusi
 * @version 2017/2/23 17:24
 */
public class AndSpecification extends CompositeSpecification {

    private ISpecification left;
    private ISpecification right;

    public AndSpecification(ISpecification left, ISpecification right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(AbstractModel condition) {
        return left.isSatisfiedBy(condition) && right.isSatisfiedBy(condition);
    }
}
