package com.maomao.leetcode.solution.solution.hard;

/**
 * 面试题56 - I. 数组中数字出现的次数
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 *
 * 限制：
 *
 * 2 <= nums <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fujie.feng
 * @Date 2020-04-28
 */
public class SingleNumbers {

	/**
	 * 异或
	 * 超时
	 */
	public int[] singleNumbers(int[] nums) {
		int ret = 0;
		for (int i : nums) {
			ret ^= i;
		}
		int div = 0;
		int a = 0, b = 0;
		while ((div & ret) == 0) {
			div <<= 1;
			for (int j : nums) {
				if ((div & j) == 0) {
					 a ^= j;
				} else {
					b ^= j;
				}
			}
		}
		return new int[]{a, b};
	}

	public int[] singleNumbers1(int[] nums) {
		int sum = 0;
		for(int num:nums){
			sum ^=num;
		}

		int flag = sum&(-sum);
		int res1 = 0;
		for(int val:nums){
			if((flag&val)!=0){
				res1 ^=val;
			}
		}

		return new int[]{res1,res1^sum};
	}

	/**
	 * 二分加异或
	 * @param nums
	 * @return
	 */
	public int[] singleNumbers2(int[] nums) {
		int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, zeroCount = 0;
		for (int num : nums) {
			if (num == 0) {
				zeroCount += 1;
			}
			min = Math.min(min, num);
			max = Math.max(max, num);
			sum ^= num;
		}
		// 需要特判一下某个数是0的情况。
		if (zeroCount == 1) {
			return new int[]{sum, 0};
		}
		int lo = min, hi = max;
		while (lo <= hi) {
			// 根据 lo 的正负性来判断二分位置怎么写，防止越界。
			int mid = lo < 0 ? lo + hi >> 1 : lo + (hi - lo) / 2;
			int loSum = 0, hiSum = 0;
			for (int num : nums) {
				if (num <= mid) {
					loSum ^= num;
				} else {
					hiSum ^= num;
				}
			}
			if (loSum != 0 && hiSum != 0) {
				// 两个都不为0，说明 p 和 q 分别落到2个数组里了。
				return new int[]{loSum, hiSum};
			}
			if (loSum == 0) {
				// 说明 p 和 q 都比 mid 大，所以比 mid 小的数的异或和变为0了。
				lo = mid;
			} else {
				// 说明 p 和 q 都不超过 mid
				hi = mid;
			}
		}
		// 其实如果输入是符合要求的，程序不会执行到这里，为了防止compile error加一下
		return null;
	}
}
