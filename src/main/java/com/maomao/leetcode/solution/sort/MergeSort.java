package com.maomao.leetcode.solution.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 步骤：
 * 1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列。
 * 2.设定两个指针，最初位置分别为两个已经排序序列的起始位置。
 * 3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一个位置。
 * 4.重复步骤3直到某一指针达到序列尾部。
 * 5.将另一个序列剩下的所有元素直接复制到合并队列的尾部。
 *
 * @auther: fujie.feng
 * @DateT: 2019-12-25
 */
public class MergeSort extends BaseSort{

    public MergeSort(int[] nums) {
        super(nums);
    }

    @Override
    public int[] sort() {
        return mergeSort(arr);
    }

    public int[] mergeSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int middle = (int) Math.floor(nums.length / 2);
        int[] left = Arrays.copyOfRange(nums, 0, middle);
        int[] right = Arrays.copyOfRange(nums, middle, nums.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1 , left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }
}
