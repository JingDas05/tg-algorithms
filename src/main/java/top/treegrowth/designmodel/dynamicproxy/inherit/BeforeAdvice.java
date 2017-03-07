package top.treegrowth.designmodel.dynamicproxy.inherit;

/**
 * @author wusi
 * @version 2017/3/7 9:15
 */
public class BeforeAdvice implements IAdvice{
    @Override
    public void exec() {
        System.out.println("前置通知");
    }
}
