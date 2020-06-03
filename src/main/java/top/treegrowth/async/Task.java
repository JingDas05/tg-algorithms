package top.treegrowth.async;

import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * @author wusi
 * @since 2019-10-31 08:29
 */
class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算>"+DateUtil.getNowTimeString());
        Thread.sleep(30000);
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        System.out.println("子线程完成计算<"+DateUtil.getNowTimeString());
        System.out.println("子线程堆栈信息"+ Arrays.toString(Thread.currentThread().getStackTrace()));
        System.out.println("子线程id"+ Thread.currentThread().getId());
        return sum;
    }
}
