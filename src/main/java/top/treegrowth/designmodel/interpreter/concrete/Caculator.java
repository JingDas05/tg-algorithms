package top.treegrowth.designmodel.interpreter.concrete;

import java.util.Map;

/**
 * 构建语法树
 * <p>
 * 这个地方封装了进行语法判断，并产生递归调用
 * 产生一个完整的语法树，由各各个具体的语法分析进行解析
 *
 * @author wusi
 * @version 2017/3/14 13:15
 */
public class Caculator {

    private Expression expression;

    public Caculator(String expStr) {

        this.expression = null;
    }

    public int run(Map<String, Integer> ctx) {
        return this.expression.interpret(ctx);
    }
}
