package top.treegrowth.algorithms.sort;

import top.treegrowth.algorithms.common.Utils;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * 插入排序算法
 * 1.首先对数组的前两个数据进行从小到大的排序
 * 2.接着将第3个数据与排序号的两个数据比较，将第3个数据插入到合适的位置
 * 3.然后，将第4个数据插入到已排好序的前三个数据中
 * 4.不断重复上述过程，直到把最后一个数据插入合适位置，最后便完成了对原始数组的从小到大的排序
 *
 * @author wusi
 * @version 2017/7/31 14:24
 */
public class InsertSort {

    // 增序排列
    public void insertionSort(int[] a) {
        int i, j, t, h;
        for (i = 1; i < a.length; i++) {
            // 需要移动的待插入元素保存到t中
            t = a[i];
            // j 需要插入的位置
            j = i - 1;
            // 移动（要插入的元素小于目标元素）
            while (j >= 0 && t < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            // 移动完毕，赋值
            a[j + 1] = t;
            print(a);
        }
    }
}
