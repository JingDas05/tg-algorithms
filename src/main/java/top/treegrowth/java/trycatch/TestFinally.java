package top.treegrowth.java.trycatch;

/**
 * @author wusi
 * @version 2018/8/24.
 */
public class TestFinally {

    public static void main(String[] args) {

        try {
            throw new RuntimeException();
        } finally {
            System.out.println("finally");
        }

    }
}
