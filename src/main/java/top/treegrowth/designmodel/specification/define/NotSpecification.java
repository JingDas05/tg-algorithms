package top.treegrowth.designmodel.specification.define;

/**
 * @author wusi
 * @version 2017/2/23 17:24
 */
public class NotSpecification extends CompositeSpecification {

    private ISpecification target;

    public NotSpecification(ISpecification target) {
        this.target = target;
    }

    @Override
    public boolean isSatisfiedBy(Object value) {
        return !target.isSatisfiedBy(value);
    }
}
