package top.treegrowth.designmodel.dynamicproxy.factoryget;

/**
 * @author wusi
 * @version 2017/3/6 12:49
 */
public class ConcreteSubject implements ISubject {
    @Override
    public void doSomething(String str) {
        System.out.println("实际的方法" + str);
    }
}
