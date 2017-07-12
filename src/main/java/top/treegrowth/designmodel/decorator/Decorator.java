package top.treegrowth.designmodel.decorator;

/**
 *
 *
 * @author wusi
 * @version 2017/2/27 9:53
 */
public abstract class Decorator extends AbstractComponent {

    public AbstractComponent abstractComponent;

    public Decorator(AbstractComponent abstractComponent) {
        this.abstractComponent = abstractComponent;
    }

    @Override
    public void operate() {
        this.abstractComponent.operate();
    }
}
