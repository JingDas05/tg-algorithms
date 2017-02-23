package top.treegrowth.designmodel.specification.define;

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
    public boolean isSatisfiedBy(Object value) {
        return left.isSatisfiedBy(value) && right.isSatisfiedBy(value);
    }
}
