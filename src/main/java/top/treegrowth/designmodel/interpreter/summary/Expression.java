package top.treegrowth.designmodel.interpreter.summary;

/**
 * @author wusi
 * @version 2017/3/14 12:35
 */
public abstract class Expression {

    public abstract Object interpret(Context ctx);
}
