package top.treegrowth.designmodel.specification;

import top.treegrowth.designmodel.specification.define.CompositeSpecification;

/**
 * @author wusi
 * @version 2017/2/23 17:44
 */
public class LargeSpecification extends CompositeSpecification {

    private int target;

    public LargeSpecification(int condition) {
        this.target = condition;
    }

    @Override
    public boolean isSatisfiedBy(Object value) {
        return Integer.parseInt(String.valueOf(value)) > target;
    }
}
