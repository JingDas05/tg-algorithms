package top.treegrowth.designmodel.specification;

import top.treegrowth.designmodel.specification.define.CompositeSpecification;

/**
 * @author wusi
 * @version 2017/2/23 17:41
 */
public class EqualSpecification extends CompositeSpecification {

    private String condition;

    public EqualSpecification(String condition) {
        this.condition = condition;
    }

    @Override
    public boolean isSatisfiedBy(Object value) {
        return condition.equals(String.valueOf(value));
    }
}
