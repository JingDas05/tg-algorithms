package top.treegrowth.designmodel.bridge;

/**
 * 这个是个抽象桥梁，把它的子类和 Implement 联系起来了
 *
 * @author wusi
 * @version 2017/2/23 13:45
 */
public abstract class Abstract {

    private Implement impl;

    //这个地方，不是默认的构造函数，会强制继承的子类去实现这个构造函数，默认的构造函数已经没了
    public Abstract(Implement impl) {
        this.impl = impl;
    }

    public void request() {
        this.impl.doSomething();
    }
}
