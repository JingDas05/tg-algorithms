package top.treegrowth.springsource.aop;

import java.lang.annotation.*;

/**
 * @author wusi
 * @version 2017/4/21 14:14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
@Inherited
public @interface HotId {
}
