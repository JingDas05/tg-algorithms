package top.treegrowth.designmodel.facade;

/**
 * @author wusi
 * @version 2017/3/11 20:41.
 */
public class Context {

    private ClassA classA = new ClassA();
    private ClassB classB = new ClassB();

    public void methodC(){
        this.classA.doSomethingA();
        this.classB.doSomethingB();
    }
}
