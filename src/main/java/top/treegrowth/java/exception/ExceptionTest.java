package top.treegrowth.java.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wusi
 * @version 2017/11/22 20:33.
 */
public class ExceptionTest {



    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ExceptionTest.class);
        String test = null;
        String test2 = null;
        try {
            test.equals(test2);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("空指针异常", e);
        }
    }
}
