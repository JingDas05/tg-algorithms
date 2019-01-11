package top.treegrowth.java.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author wusi
 * @version 2019/1/10 22:23.
 */
@Aspect
@Component
public class TimerAspect {

    @Pointcut("@annotation(top.treegrowth.java.aop.Timer)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("before");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after");
    }
}
