package top.treegrowth.algorithms.sort;

import top.treegrowth.algorithms.common.Utils;

import static top.treegrowth.algorithms.common.Utils.exch;
import static top.treegrowth.algorithms.common.Utils.less;

/**
 * @author wusi
 * @version 20170212
 */
public class SlectionSort {


    /**
     * @param args 需要排序的数组
     */
    public void sort(Comparable[] args) {
        int length = args.length;
        //依次选择数组里的元素
        for (int i = 0; i < length; i++) {
            //选择大于等于当前元素到末尾的全部元素，与当前元素比较大小，并且调换顺序
            for (int j = i + 1; j < length; j++) {
                //如果后面的比前面的小就调换顺序（增序）
                if (less(args[j], args[i])) {
                    exch(args, i, j);
                }
            }
        }
    }
}
