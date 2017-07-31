package top.treegrowth.algorithms.sort;

import top.treegrowth.algorithms.common.Utils;

import static top.treegrowth.algorithms.common.Utils.exchange;
import static top.treegrowth.algorithms.common.Utils.more;
import static top.treegrowth.algorithms.common.Utils.print;

/**
 * 交换排序法
 * 冒泡排序算法
 * 1, 对于数组中的各数据，依次比较相邻的两个元素的大小
 * 2. 如果前面的数据大于后面的数据，就交换这两个数据。经过第一轮的多次排序比较，最小的数据在前面（反之亦然）
 * 3. 再用相同的办法把剩下的数据逐个进行比较，数据就像冒泡一样，把一次比较的数据冒泡到最前或者最后
 *
 * @author wusi
 * @version 2017/7/31 8:57
 */
public class ExchangeSort {

    // 较大的数往后冒泡
    public void bubbleSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                // 较大的数往后冒泡
                if (more(a[j], a[j + 1])) {
                    // 交换相邻两个数
                    exchange(a, j, j + 1);
                }
                print(a);
            }
        }
    }
}

