package top.treegrowth.java.extend;

/**
 * @author wusi
 * @version 2018/4/26 8:15.
 */
public class Student implements Person, Named {


    @Override
    public String getName() {
        return getClass().getName()+"1";
    }
}
