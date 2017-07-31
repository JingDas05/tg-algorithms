package top.treegrowth.algorithms.sort;

import top.treegrowth.algorithms.common.Utils;

import static top.treegrowth.algorithms.common.Utils.print;

/**
 * Shell排序算法（希尔排序， !!!!缩小增量排序!!!!）
 * 1.将有n个数据的数组分成n/2个序列（增量为n/2），第1个数据和第1+n/2个数据为一个序列，第2个数据和第2+n/2个数据为一个序列，依次类推...
 * 2.一次循环每一个序列插入顺序
 * 3.然后，再变成n/2/2个序列（增量为n/2/2），第1个数据和第1+n/4， 1+n/4 *2, 1+n/4 *3 ......数据为一个序列,
 * 第2个数据和第2+n/4， 2+n/4 *2, 2+n/4 *3 ......数据为一个序列
 * 4.一次循环每一个序列插入排序
 * 5.不断重复上述操作，随着序列最后变成1个（增量为n/n,也就是1），插入排序，就完成了整个排序
 * <p>
 * 插入排序时，如果原数据已经基本有序，排序效率大大提高
 *
 * @author wusi
 * @version 2017/7/31 15:18
 */
public class InsertShellSort {

    public void shellSort(Integer[] a) {
        int i, j, h;
        int range, temp;
        int length = a.length;

        // 定义增量，划组
        for (range = length / 2; range >= 1; range /= 2) {
            // 对于每一组进行插入排序
            for (i = range; i < length; i++) {
                // 要插入的元素存入中间变量
                temp = a[i];
                // 要插入的位置
                j = i - range;
                // 插入排序
                // 如果目标数据小于要插入的位置的数据，移动（增序）
                while (j > 0 && temp < a[j]) {
                    a[j + range] = a[j];
                    j -= range;
                }
                a[j + range] = temp;
            }
            print(a);
        }
    }
}
