package top.treegrowth.designmodel.specification;

/**
 * @author wusi
 * @version 2017/2/23 17:39
 */
public class Client {

    public static void main(String[] args) {

    }

    public void testsingleton() {
        if (new EqualSpecification("12").isSatisfiedBy("12")) {
            System.out.println("singleton test success");
        }
    }

    public void testComposite() {
        if (new EqualSpecification("12").or(new LargeSpecification(3)).isSatisfiedBy("12")) {
            System.out.println("singleton test success");
        }
    }
}
