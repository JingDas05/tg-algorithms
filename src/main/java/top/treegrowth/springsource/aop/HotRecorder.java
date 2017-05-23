package top.treegrowth.springsource.aop;

import java.lang.annotation.*;

/**
 *
 * key 为业务区分, 目前只支持取对象中的属性
 * id 操作目标id， 目前只支持取对象中的属性
 *
 * @author wusi
 * @version 2017/3/16 14:57
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface HotRecorder {

    String key();
    String id() default "";
}
