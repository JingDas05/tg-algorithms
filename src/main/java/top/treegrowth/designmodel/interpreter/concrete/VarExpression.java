package top.treegrowth.designmodel.interpreter.concrete;

import java.util.Map;

/**
 * @author wusi
 * @version 2017/3/14 13:06
 */
public class VarExpression extends Expression {

    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpret(Map<String, Integer> ctx) {
        return ctx.get(this.key);
    }
}
