package top.treegrowth.java.aop;

import java.lang.annotation.*;

/**
 * @author wusi
 * @version 2019/1/10 22:18.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Timer {
}
