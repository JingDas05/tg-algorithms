package top.treegrowth.designmodel.chain_of_reposibility;

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
 * @version 2017/2/25 22:45.
 */
public class Client {

    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNextHandler(handler2);

        Request request = new Request();
        handler1.handleMessage(request);
    }
}
