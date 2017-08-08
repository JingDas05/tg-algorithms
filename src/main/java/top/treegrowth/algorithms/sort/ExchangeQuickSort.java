package top.treegrowth.algorithms.sort;

/**
 * 快速排序算法
 * 1.首先设定一个分界值，通过该分界值将数组分成左右两部分
 * 2.将所有大于分界值的数据集中到数组右边， 小于分界值的数据集中到数组的左面
 * 3.然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两部分，同样将
 * 左边放置较小值，右边放置较大值。右侧的数组数据也可以做类似处理
 * 4.重复上述过程，递归操作，当左 右两个部分个数据排序完成后，整个数组的排序也就完成了
 *
 * @author wusi
 * @version 2017/8/1 10:42
 */
public class ExchangeQuickSort {

    public void quickSort(int[] a, int left, int right) {

        int theChosenValue, temp;
        // 左右游标，不断向 theChosenValue 靠近
        int rTemp, lTemp;
        lTemp = left;
        rTemp = right;
        // 分界值
        theChosenValue = a[(left + right) / 2];
        // 当左右游标还没有重合时
        while (lTemp < rTemp) {
            // 如果左游标小于分界值，继续向右移动
            while (a[lTemp] < theChosenValue) {
                ++lTemp;
            }
            // 如果右游标大于分界值，继续向左移动
            while (a[rTemp] > theChosenValue) {
                --rTemp;
            }
            // 经历过上面的循环，分界值左边的游标位于第一个大于分界值的位置，分界值右边的游标位于
            // 第一个小于分界值的位置
            if (lTemp <= rTemp) {
                // 互换左右游标所在位置的值
                temp = a[lTemp];
                a[lTemp] = a[rTemp];
                a[rTemp] = temp;
            }
            // 经历过上面的互换之后，如果执行到这里，证明本轮排序完事了
            // 分界值左边的值都比分界值小，分界值右边的值都比分界值大
            if (lTemp == rTemp) {
                lTemp++;
            }
            // 递归进行排序
            // 如果左边界小于右游标
            if (left < rTemp) {
                quickSort(a, left, lTemp - 1);
            }
            // 如果左游标小于右边界
            if (lTemp < right) {
                quickSort(a, rTemp + 1, right);
            }
        }
    }
}
