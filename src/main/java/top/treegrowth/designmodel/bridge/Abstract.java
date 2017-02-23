package top.treegrowth.designmodel.bridge;

/**
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
