package top.treegrowth.designmodel.decorator;

/**
 *
 * 单一职责原则
 * 依赖倒置原则
 * 接口隔离原则
 * 迪米特原则
 * 里氏替换原则
 * 开闭原则
 *
 * @author wusi
 * @version 2017/7/12 8:57
 */
public class Client {

    public static void main(String[] args) {
        AbstractComponent component = new ConcereteComponent1();
        component = new ConcereteDecoreator1(component);
        component = new ConcereteDecoreator2(component);
        component.operate();
    }
}
