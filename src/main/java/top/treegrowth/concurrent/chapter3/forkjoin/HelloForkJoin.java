package top.treegrowth.concurrent.chapter3.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @author wusi
 * @version 2017/2/27 19:51.
 */
public class HelloForkJoin {

    ForkJoinPool pool;

    RecursiveAction recursiveAction;

    RecursiveTask recursiveTask;
}
