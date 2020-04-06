package com.maomao.leetcode.solution.sort;

/**
 * 计数排序
 * 步骤：
 * 1.在O(n)的时间扫描一下整个序列a，找到序列中最大值max和最小值min。
 * 2.开辟一块新的空间创建新的数组b，长度为max-min+1。
 * 3.数字b中的index的元素记录的值是a中元素的出现次数。
 * 4.最后输出目标整数序列，具体的逻辑是遍历数组b，输出相应元素以及对应的个数。
 *
 * @auther: fujie.feng
 * @DateT: 2019-12-25
 */
public class CountSort extends BaseSort{
    public CountSort(int[] nums) {
        super(nums);
    }

    @Override
    public int[] sort() {
        return countSort(arr, getMaxValue(arr));
    }

    public int[] countSort(int[] nums, int max) {
        int bucketLen = max + 1;
        int[] bucket = new int[bucketLen];
        for (int i : nums) {
            bucket[i]++;
        }
        int sortedIndex = 0;
        for (int i = 0; i < bucketLen; i++) {
            while (bucket[i] > 0) {
                nums[sortedIndex++] = i;
                bucket[i]--;
            }
        }
        return nums;
    }

    public int getMaxValue(int[] nums) {
        int maxValue = arr[0];
        for (int i : nums) {
            if (maxValue < i) {
                maxValue = i;
            }
        }
        return maxValue;
    }
}
