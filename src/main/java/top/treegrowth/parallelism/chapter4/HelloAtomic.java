package top.treegrowth.parallelism.chapter4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wusi
 * @version 2017/3/13 7:20.
 */
public class HelloAtomic {

    //这个是符合CAS原子操作的，全称是 compare and swap
    private AtomicInteger atomicInteger;
}
