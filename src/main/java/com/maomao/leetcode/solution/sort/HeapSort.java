package com.maomao.leetcode.solution.sort;

/**
 * 堆排序
 * 步骤：
 * 1.创建一个heap，H[0....n-1].
 * 2.把堆首（最大值）和堆尾互换。
 * 3.把堆的大小缩小1，并调用shift_down(0), 目的是把新的数组顶端数据调整到相应的位置。
 * 4.重复步骤2，直到到堆的大小变为1。
 *
 * @auther: fujie.feng
 * @DateT: 2019-12-25
 */
public class HeapSort extends BaseSort {

    public HeapSort(int[] nums) {
        super(nums);
    }

    @Override
    public int[] sort() {
        int len = arr.length;
        bulidMaxHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    public void bulidMaxHeap(int[] nums, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(nums, i, len);
        }
    }

    private void heapify(int[] nums, int i, int len) {
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;

        int last = i;
        if (left < len && nums[left] > nums[last]) {
            last = left;
        }
        if (right < len && nums[right] > nums[last]) {
            last = right;
        }
        if (last != i) {
            swap(nums, i, last);

            heapify(nums, last, len);
        }
    }
}
