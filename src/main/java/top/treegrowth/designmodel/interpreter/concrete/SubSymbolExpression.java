package top.treegrowth.designmodel.interpreter.concrete;

import java.util.Map;

/**
 * @author wusi
 * @version 2017/3/14 13:14
 */
public class SubSymbolExpression extends SymbolExpression {

    public SubSymbolExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret(Map<String, Integer> ctx) {
        return super.left.interpret(ctx) - super.right.interpret(ctx);
    }
}
