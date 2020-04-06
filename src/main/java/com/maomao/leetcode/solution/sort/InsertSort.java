package com.maomao.leetcode.solution.sort;

/**
 * 插入排序
 * 步骤：
 * 1.将第一待排序序列的第一个元素看做是一个有序的序列，把第二个元素到最后一个元素当成是未排序的序列。
 * 2.从头到尾依次扫描未排序的序列，将扫描到的每个元素插入有序序列的适当位置，
 * 3.如果待插入的元素与有序序列中的某个元素相等，则将待插入的元素插入到相等元素的后面。
 *
 * @auther: fujie.feng
 * @DateT: 2019-12-25
 */
public class InsertSort extends BaseSort {

    public InsertSort(int[] nums) {
        super(nums);
    }

    @Override
    public int[] sort() {

        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;

            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j -1];
                j--;
            }

            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }
}
