package top.treegrowth.java.conconrent;

/**
 * @author wusi
 * @version 2017/8/2 10:32
 */
public class ThreadLoaclTest {

    protected static final ThreadLocal<Param> LOCAL_PAGE = new ThreadLocal<Param>();

    public static void main(String[] args) {
        Param param1 = new Param("1");
        LOCAL_PAGE.set(param1);
        System.out.println(LOCAL_PAGE.get().getName());
        Param param2 = new Param("2");
        LOCAL_PAGE.set(param2);
        System.out.println(LOCAL_PAGE.get().getName());
    }
}
