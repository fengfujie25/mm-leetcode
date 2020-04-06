package com.maomao.leetcode.solution.sort;

/**
 * 快速排序
 * 步骤：
 * 1.从数列中挑出一个元素，称为基准（pivot）。
 * 2.重新排序数列，所有元素比基准小的，全部放到基准前边，比基准大的全部放到基准后面（如果与基准相等，可以放到任意一边）。在这个分区退出之后，该基准就处于数列的中间位置，也就是分区操作，每个分区被称做一个partition
 * 3.递归排序两个partition。
 *
 * @auther: fujie.feng
 * @DateT: 2019-12-25
 */
public class QuickSort extends BaseSort {

    public QuickSort(int[] nums) {
        super(nums);
    }

    @Override
    public int[] sort() {
        return quickSort(arr, 0, arr.length - 1);
    }

    public int[] quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partition = partition(nums, left, right);
            quickSort(nums, left, partition -1);
            quickSort(nums, partition + 1, right);
        }
        return nums;
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, index);
                index++;

            }
        }
        swap(nums, pivot, index - 1);
        return index - 1;
    }
}
