package top.treegrowth.designmodel.facade;

/**
 * @author wusi
 * @version 2017/3/11 20:42.
 */
public class Facade1 {

    private Facade2 facade2 = new Facade2();

    //对外提供唯一的访问子系统的方法
    public void methodB() {
        this.facade2.methodB();
    }
}
