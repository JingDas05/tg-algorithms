package top.treegrowth.designmodel.interpreter.summary;

/**
 * 终端表达式
 *
 * @author wusi
 * @version 2017/3/14 12:52
 */
public class TerminalExpression extends Expression {

    //通常终结符表达式只有一个，但是有多个对象
    @Override
    public Object interpret(Context ctx) {
        return null;
    }
}
