package top.treegrowth.designmodel.decorator;

/**
 * @author wusi
 * @version 2017/2/27 9:57
 */
public class ConcereteDecoreator1 extends Decorator {

    public ConcereteDecoreator1(AbstractComponent abstractComponent) {
        super(abstractComponent);
    }

    public void selfMethod() {

    }

    //修饰装饰的abstractComponent 添加行为
    @Override
    public void operate() {
        this.selfMethod();
        super.operate();
    }
}
