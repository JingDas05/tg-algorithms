package top.treegrowth.designmodel.specification.define;

import top.treegrowth.designmodel.specification.model.AbstractModel;

/**
 * @author wusi
 * @version 2017/2/23 17:32
 */
public abstract class CompositeSpecification implements ISpecification {

    @Override
    public abstract boolean isSatisfiedBy(AbstractModel condition);

    @Override
    public ISpecification and(ISpecification iSpecification) {
        return new AndSpecification(this, iSpecification);
    }

    @Override
    public ISpecification or(ISpecification iSpecification) {
        return new OrSpecification(this, iSpecification);
    }

    @Override
    public ISpecification not(ISpecification iSpecification) {
        return new NotSpecification(iSpecification);
    }
}
