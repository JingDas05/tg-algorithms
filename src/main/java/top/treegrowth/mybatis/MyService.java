package top.treegrowth.mybatis;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.treegrowth.mybatis.mapper.MyMapper;
import top.treegrowth.mybatis.mapper.YouMapper;
import top.treegrowth.mybatis.model.My;
import top.treegrowth.mybatis.model.You;

import javax.annotation.Resource;

/**
 * @author wusi
 */

@Service
public class MyService {

    @Resource
    private MyMapper myMapper;
    @Resource
    private YouMapper youMapper;

    //    @Transactional(noRollbackFor = RuntimeException.class)
    /**
     * Transactional原理 CglibAopProxy 是关键类
     *
     * 调用 determineTransactionAttribute
     *
     * 调用
     * SpringTransactionAnnotationParser#parseTransactionAnnotation
     * 调用
     * ProxyFactory#getProxy(@Nullable ClassLoader classLoader)
     * 调用
     * CglibAopProxy#getProxy
     * 调用
     * CglibAopProxy#getCallbacks
     * 调用
     * CglibAopProxy $ DynamicAdvisedInterceptor#intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)
     * 注：CglibMethodInvocation继承ReflectiveMethodInvocation
     * 调用
     * ReflectiveMethodInvocation#proceed()
     * 调用
     * TransactionInterceptor#invoke(final MethodInvocation invocation)
     * 调用
     * TransactionAspectSupport#invokeWithinTransaction(Method method, @Nullable Class<?> targetClass,final InvocationCallback invocation)
     * 如果出现异常调用
     * TransactionAspectSupport#completeTransactionAfterThrowing(@Nullable TransactionInfo txInfo, Throwable ex)
     * 回滚时调用
     * AbstractPlatformTransactionManager#rollback(TransactionStatus status)方法
     * 实际调用
     * DataSourceTransactionManager#doRollback(DefaultTransactionStatus status)方法
     * */
    @Transactional()
    public void insert() {
        My my = new My();
        my.setId(111);
        my.setName("名字1");
        my.setAge(1);
        myMapper.insert(my);
        You you = new You();
        you.setId(222);
        you.setName("名字2");
        you.setAge(2);
        youMapper.insert(you);
        throw new RuntimeException();
    }
}
