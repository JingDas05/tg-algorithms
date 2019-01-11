package top.treegrowth.java.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wusi
 * @version 2019/1/11 7:48.
 */
@Component
public class TimerService {

    @Autowired
    private TimerService timerServiceAop;

    public void helloWithoutAop() {
        // 上下文，this 不是动态代理的对象，所以调用hello，aop失效
        System.out.println("失效时当前的hashcode" + this.hashCode());
        // 没有走横切逻辑
        hello("aop");
        // 使用代理执行下面的方法,aop生效
        System.out.println("生效时当前的hashcode" + timerServiceAop.hashCode());
        timerServiceAop.hello("aop-subtle");
    }

    @Timer
    public void hello(String content) {
        System.out.println("hello" + content);
    }
}
