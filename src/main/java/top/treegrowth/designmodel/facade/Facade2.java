package top.treegrowth.designmodel.facade;

/**
 * @author wusi
 * @version 2017/3/11 20:39.
 */
public class Facade2 {

    private ClassA classA = new ClassA();
    private ClassB classB = new ClassB();
    private Context context = new Context();

    public void methodA() {
        this.classA.doSomethingA();
    }

    public void methodB() {
        this.classB.doSomethingB();
    }

    //这里直接引用的前面的方法A和方法B，也可以封装成context,如下面的 methodCWithContext
    public void methodC() {
        this.classA.doSomethingA();
        this.classB.doSomethingB();
    }

    public void methodCWithContext() {
        context.methodC();
    }
}
