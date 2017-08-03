package top.treegrowth.algorithms.sort;

import static top.treegrowth.algorithms.common.Utils.exchange;
import static top.treegrowth.algorithms.common.Utils.less;

/**
 *
 * 选择排序法（增序）
 *
 *  1 首先从原始数组中选择最小的一个数据，将其和位于第一个位置的数据交换
 *  2 接着从剩下的 n-1 个数据选择小的一个元素，将其和第二个位置的数据交换
 *  3 然后，这样不断重复，直到最后两个数据交换完成，至此，便完成了对原始数组的从小到大的排序
 *
 * @author wusi
 * @version 20170212
 */
public class SlectionBasicSort {


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
                    exchange(args, i, j);
                }
            }
        }
    }
}
