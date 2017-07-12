package top.treegrowth.designmodel.decorator;

/**
 * @author wusi
 * @version 2017/7/12 9:00
 */
public class ConcereteDecoreator2 extends Decorator {
    public ConcereteDecoreator2(AbstractComponent abstractComponent) {
        super(abstractComponent);
    }

    public void selfMethod() {
        System.out.println("装饰者2");
    }

    //修饰装饰的abstractComponent 添加行为
    @Override
    public void operate() {
        this.selfMethod();
        super.operate();
    }
}
