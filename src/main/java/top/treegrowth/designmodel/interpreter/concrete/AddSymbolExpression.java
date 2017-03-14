package top.treegrowth.designmodel.interpreter.concrete;

import java.util.Map;

/**
 * @author wusi
 * @version 2017/3/14 13:10
 */
public class AddSymbolExpression extends SymbolExpression {

    public AddSymbolExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret(Map<String, Integer> ctx) {
        return super.left.interpret(ctx) + super.right.interpret(ctx);
    }
}
