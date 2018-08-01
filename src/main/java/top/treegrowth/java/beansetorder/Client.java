package top.treegrowth.java.beansetorder;

/**
 * @author wusi
 */
public class Client {

    public static void main(String[] args) {
        System.out.println(get());
    }

    public static Bean get() {
        Bean bean = new Bean();
        bean.setName("name");
        return bean;
    }
}
