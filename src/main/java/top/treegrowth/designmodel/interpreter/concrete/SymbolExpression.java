package top.treegrowth.designmodel.interpreter.concrete;

/**
 * @author wusi
 * @version 2017/3/14 13:08
 */
public abstract class SymbolExpression extends Expression {

    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
