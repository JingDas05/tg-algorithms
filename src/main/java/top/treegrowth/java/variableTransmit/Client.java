package top.treegrowth.java.variableTransmit;

/**
 * @author wusi
 * @version 2017/12/17 7:47.
 */
public class Client {

    public static void main(String[] args) {
        VariableTest variableTest = new VariableTest();
        System.out.println(variableTest.getA());
        variableTest.changeA(1);
        System.out.println(variableTest.getA());
    }
}
