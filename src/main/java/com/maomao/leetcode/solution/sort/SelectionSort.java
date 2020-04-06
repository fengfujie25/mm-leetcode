package com.maomao.leetcode.solution.sort;

/**
 * 选择排序
 *
 * 步骤：
 * 1.首先在未排序的序列中找到最小/大的元素，存放到排序序列的起始位置。
 * 2.再从剩余未排序元素中继续寻找最小/大的元素，然后放到已排序序列的末尾。
 * 3.重复2步骤，知道所有元素均排序完毕
 *
 * @auther: fujie.feng
 * @DateT: 2019-12-24
 */
public class SelectionSort extends BaseSort {


    public SelectionSort(int[] nums) {
        super(nums);
    }

    @Override
    public int[] sort() {
        //总共要进行n-1次比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    //记录最小元素下标
                    min = j;
                }
            }
            //交换最小值和i的位图
            if (i != min) {
                swap(arr, i, min);
            }
        }
        return arr;
    }
}
