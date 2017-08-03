package top.treegrowth.algorithms.sort;

/**
 * 快速排序算法
 * 1.首先设定一个分界值，通过该分界值将数组分成左右两部分
 * 2.将所有大于分界值的数据集中到数组右边， 小于分界值的数据集中到数组的左面
 * 3.然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两部分，同样将
 *   左边放置较小值，右边放置较大值。右侧的数组数据也可以做类似处理
 * 4.重复上述过程，递归操作，当左 右两个部分个数据排序完成后，整个数组的排序也就完成了
 *
 * @author wusi
 * @version 2017/8/1 10:42
 */
public class ExchangeQuickSort {

    public void quickSort(int[] a, int left, int right) {

        int theChosenValue, temp;
        int rTemp, lTemp;
    }
}
