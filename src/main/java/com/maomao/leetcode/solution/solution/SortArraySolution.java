package com.maomao.leetcode.solution.solution;

import java.util.Arrays;

/**
 * @author fujie.feng
 * @Date 2020-03-30
 */
public class SortArraySolution {



    public static int[] sortArray(int[] nums) {

        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int[] counter = new int[max - min + 1];
        for (int num : nums) {
            counter[num - min]++;
        }
        int index = 0;
        for (int num = min; num <= max; num++) {
            int cnt = counter[num - min];
            while (cnt-- > 0) {
                nums[index++] = num;

            }
        }
        return nums;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{2,2,3,345,4,65};
        SortArraySolution.sortArray(arr);
    }

}
