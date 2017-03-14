package top.treegrowth.designmodel.interpreter.concrete;

import java.util.Map;

/**
 * @author wusi
 * @version 2017/3/14 13:05
 */
public abstract class Expression {

    public abstract int interpret(Map<String, Integer> ctx);
}
