package com.maomao.leetcode.solution.sort;

/**
 * 冒泡排序
 *
 * 步骤：
 * 1. 比较相邻的2个元素，如果第一个比第二个大，就交换他们的位置。
 * 2. 对每一对相邻元素做同样的操作，从开始第一对到结尾的最后一对，这步骤完成后，最后的元素会是最大的元素。
 * 3. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
 * @auther: fujie.feng
 * @DateT: 2019-12-23
 */
public class BubbleSort extends BaseSort {

    public BubbleSort(int[] nums) {
        super(nums);
    }

    @Override
    public int[] sort() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    super.swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }
}
