package com.maomao.leetcode.solution.sort;

import java.util.Arrays;

/**
 * 基数排序
 * 步骤：
 * 1.将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数据前面补零。
 * 2.从最低位开始，依次进行一次排序。
 * 3.从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列。
 *
 * @auther: fujie.feng
 * @DateT: 2019-12-25
 */
public class RadixSort extends BaseSort{

    public RadixSort(int[] nums) {
        super(nums);
    }

    @Override
    public int[] sort() {
        return radixSort(arr, getMaxDigit(arr));
    }

    public int[] radixSort(int[] nums, int maxDigit) {
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < nums.length; j++) {
                int bucket = ((nums[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], nums[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    nums[pos++] = value;
                }
            }

        }
        return nums;
    }

    private int[] arrayAppend(int[] ints, int num) {
        ints = Arrays.copyOf(ints, ints.length + 1);
        ints[ints.length - 1] = num;
        return ints;
    }

    /**
     * 获取最高位数
     * @param nums
     * @return
     */
    public int getMaxDigit(int[] nums) {
        int maxValue = getMaxValue(nums);
        return getNumLenght(maxValue);
    }

    private int getNumLenght(int maxValue) {
        if (maxValue == 0) {
            return 1;
        }
        int length = 0;
        for (long tmp = maxValue; tmp != 0; tmp /= 10) {
            length++;
        }
        return length;
    }

    private int getMaxValue(int[] nums) {
        int maxValue = nums[0];
        for (int i : nums) {
            if (maxValue < i) {
                maxValue = i;
            }
        }
        return maxValue;
    }
}
