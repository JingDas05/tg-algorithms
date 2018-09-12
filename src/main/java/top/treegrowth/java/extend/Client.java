package top.treegrowth.java.extend;

/**
 * @author wusi
 * @version 2018/4/26 8:15.
 */
public class Client {

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getName());
        test(new StudentSub());
    }

    public static void test(Student student) {

    }
}
