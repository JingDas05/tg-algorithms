package top.treegrowth.springsource.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * 支持取对象中的属性以及字符串字面量，不支持取字符串值
 *
 * @author wusi
 * @version 2017/3/16 15:20
 */
@Aspect
@Component
public class HotRecorderAspect {

//    @Autowired
//    private IRedisService redisService;
    private static SpelExpressionParser parser = new SpelExpressionParser();

    @Pointcut(value = "@annotation(hotRecorder)", argNames = "hotRecorder")
    public void annotationPointCut(HotRecorder hotRecorder) {
    }

    @After(value = "annotationPointCut(hotRecorder)", argNames = "joinPoint, hotRecorder")
    public void after(JoinPoint joinPoint, HotRecorder hotRecorder) {
        String id = null;
        String key = null;
        try {
            id = hotRecorder.id();
            key = hotRecorder.key();
            String idObjectName = "";
            String idPropertyName = "";
            String keyObjectName = "";
            String keyPropertyName = "";

            if (id.contains(".")) {
                String[] idArgs = hotRecorder.id().split("\\.");
                idObjectName = idArgs[0];
                idPropertyName = idArgs[1];
            }

            if (key.contains(".")) {
                String[] keyArgs = key.split("\\.");
                keyObjectName = keyArgs[0];
                keyPropertyName = keyArgs[1];
            }

            //获取当前方法的注解
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Annotation[][] annotations = methodSignature.getMethod().getParameterAnnotations();
            //获取当前方法的参数
            Object[] args = joinPoint.getArgs();

            for (int i = 0; i < args.length; i++) {
                if (!(args[i] instanceof String)) {
                    //解析不是String 类型的对象以及属性
                    String name = args[i].getClass().getSimpleName();
                    if (name.equals(idObjectName)) {
                        id = parser.parseExpression(idPropertyName).getValue(args[i], String.class);
                    }
                    if (name.equals(keyObjectName)) {
                        key = parser.parseExpression(keyPropertyName).getValue(args[i], String.class);
                    }
                }
                //解析自定义注解的值
                for (Annotation a : annotations[i]) {
                    if (a instanceof HotId) {
                        id = String.valueOf(args[i]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("key:" + key + "id:" + id);
//        redisService.addValueToSet(key, id);
    }
}
