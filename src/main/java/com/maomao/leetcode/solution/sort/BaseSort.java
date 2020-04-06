package com.maomao.leetcode.solution.sort;

import java.util.Arrays;

/**
 * @auther: fujie.feng
 * @DateT: 2019-12-23
 */
public abstract class BaseSort {

    protected int[] arr;

    public BaseSort(int[] nums) {
        arr = Arrays.copyOf(nums, nums.length);
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void execute() {
        long t1 = System.currentTimeMillis();
        int[] a = sort();
        System.out.println("耗时啊：" + (System.currentTimeMillis() - t1) + "ms");
        print(a);
    }


    private void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public abstract int[] sort();
}
