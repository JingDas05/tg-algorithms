package top.treegrowth.parallelism.staticfield;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Administrator
 */
public class Client {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        int i = 0;
        while (true) {
            System.out.println(i++);
            executorService.submit(() -> {
                RpcContext.getContext().setRemoteAddress(Thread.currentThread().getName());
                if (!Thread.currentThread().getName().equals(RpcContext.getContext().getRemoteAddress())) {
                    System.out.println("多线程修改变量出现问题");
                    return;
                }
            });
        }
    }
}
