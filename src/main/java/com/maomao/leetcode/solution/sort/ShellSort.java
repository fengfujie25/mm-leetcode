package com.maomao.leetcode.solution.sort;

/**
 * 希尔排序
 * 步骤：
 * 1.选择一个增量序列，t1, t2, ....... , tk,其中ti>tj, tk = 1。
 * 2.按增量序列个数k，对序列进行k躺排序。
 * 3.每趟排序，根据对应的增量ti, 将待排序列分割成若干长度为m的子序列，分别对各子表进行直接插入排序，仅增量因子为1时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 * @auther: fujie.feng
 * @DateT: 2019-12-25
 */
public class ShellSort extends BaseSort {

    public ShellSort(int[] nums) {
        super(nums);
    }

    @Override
    public int[] sort() {
        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = 0; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - gap;

                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            gap = (int) Math.floor(gap / 3);
        }
        return arr;
    }
}
