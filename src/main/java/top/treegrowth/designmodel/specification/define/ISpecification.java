package top.treegrowth.designmodel.specification.define;

import top.treegrowth.designmodel.specification.model.AbstractModel;

/**
 * @author wusi
 * @version 2017/2/23 14:10
 */
public interface ISpecification {

    boolean isSatisfiedBy(AbstractModel condition);

    ISpecification and(ISpecification iSpecification);

    ISpecification or(ISpecification iSpecification);

    ISpecification not(ISpecification iSpecification);
}
