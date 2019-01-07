package top.treegrowth.concurrent.chapter3.executorpool;

import java.util.concurrent.*;

/**
 * @author wusi
 * @version 2017/2/26 11:20.
 */
public class HelloExecutor {

    Executor executor;

    ExecutorService executorService;

    Executors executors;

    //很强大的executors,其他都是基于下面的封装
    ThreadPoolExecutor threadPoolExecutor;

    ThreadFactory threadFactory;
}
