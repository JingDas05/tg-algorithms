package top.treegrowth.designmodel.specification.define;

/**
 * @author wusi
 * @version 2017/2/23 17:32
 */
public abstract class CompositeSpecification implements ISpecification {

    @Override
    public abstract boolean isSatisfiedBy(Object value);

    @Override
    public ISpecification and(ISpecification iSpecification) {
        return new AndSpecification(this, iSpecification);
    }

    @Override
    public ISpecification or(ISpecification iSpecification) {
        return null;
    }

    @Override
    public ISpecification not(ISpecification iSpecification) {
        return null;
    }
}
