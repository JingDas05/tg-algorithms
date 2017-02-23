package top.treegrowth.designmodel.specification.define;

/**
 * @author wusi
 * @version 2017/2/23 14:10
 */
public interface ISpecification {

    boolean isSatisfiedBy(Object value);

    ISpecification and(ISpecification iSpecification);

    ISpecification or(ISpecification iSpecification);

    ISpecification not(ISpecification iSpecification);
}
