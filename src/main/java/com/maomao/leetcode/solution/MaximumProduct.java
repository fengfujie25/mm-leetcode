package com.maomao.leetcode.solution;

import java.util.Arrays;

/**
 * @author fujie.feng
 * @Date 2021-01-20
 */
public class MaximumProduct {

	public int maximumProduct(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		return Math.max(nums[0] * nums[1] * nums[2], nums[n-3] *  nums[n-1] *  nums[n-2]);
	}


	public int maximumProducts(int[] nums) {
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

		for (int x : nums) {
			if (x < min1) {
				min2 = min1;
				min1 = x;
			} else if (x < min2) {
				min2 = x;
			}

			if (x > max1) {
				max3 = max2;
				max2 = max1;
				max1 = x;
			} else if (x > max2) {
				max3 = max2;
				max2 = x;
			} else if (x > max3) {
				max3 = x;
			}

		}

		return Math.max(min1 * min2 * max1, max1 * max2 * max3);
	}

}
