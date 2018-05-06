package top.treegrowth.java.enumtest;

/**
 * @author wusi
 * @version 2018/4/22 21:20.
 */
public enum Size {

    SMALL("S"), MIDDLE("M");

    private Size(String a) {
        this.a = a;
    }

    private String a;

    private String getA() {
        return this.a;
    }
}
