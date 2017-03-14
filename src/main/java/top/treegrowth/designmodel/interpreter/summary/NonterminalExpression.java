package top.treegrowth.designmodel.interpreter.summary;

/**
 * @author wusi
 * @version 2017/3/14 12:55
 */
public class NonterminalExpression extends Expression{

    //每个非终结符表达式都会对其他表达式产生依赖
     public NonterminalExpression(Expression... expressions){};

    @Override
    public Object interpret(Context ctx) {
        //进行文法处理
        return null;
    }
}
