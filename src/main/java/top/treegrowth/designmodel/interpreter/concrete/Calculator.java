package top.treegrowth.designmodel.interpreter.concrete;

import java.util.Map;
import java.util.Stack;

/**
 * 构建语法树
 * <p>
 * 这个地方封装了进行语法判断，并产生递归调用
 * 产生一个完整的语法树，由各各个具体的语法分析进行解析
 *
 * @author wusi
 * @version 2017/3/14 13:15
 */
public class Calculator {

    private Expression expression;

    public Calculator(String expStr) {

        //定义一个堆栈，安排运算的先后顺序,构建语法过程
        Stack<Expression> stack = new Stack<>();
        char[] chars = expStr.toCharArray();
        Expression left = null;
        Expression right = null;
        //解析传进来的字符串，进行构建语法树
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '+': {
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(chars[++i]));
                    stack.push(new AddSymbolExpression(left, right));
                }
                case '-': {
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(chars[++i]));
                    stack.push(new SubSymbolExpression(left, right));
                }
                default: {
                    stack.push(new VarExpression(String.valueOf(chars[i])));
                }
            }
        }

        this.expression = stack.pop();
    }

    public int run(Map<String, Integer> ctx) {
        return this.expression.interpret(ctx);
    }
}
