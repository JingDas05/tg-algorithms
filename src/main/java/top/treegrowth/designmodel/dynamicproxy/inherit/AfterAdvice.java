package top.treegrowth.designmodel.dynamicproxy.inherit;

/**
 * @author wusi
 * @version 2017/3/7 9:16
 */
public class AfterAdvice implements IAdvice{
    @Override
    public void exec() {
        System.out.println("后置通知");
    }
}
