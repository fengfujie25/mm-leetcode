package com.maomao.leetcode.solution.solution.hard;

/**
 * 面试题51. 数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fujie.feng
 * @Date 2020-04-24
 */
public class ReversePairs {

	/**
	 * 暴力法:数据量大的时候超出时间限制
	 * @param nums
	 * @return
	 */
	public int reversePairs(int[] nums) {
		int sum = 0, len = nums.length;

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (nums[i] > nums[j]) {
					sum++;
				}
			}
		}
		return sum;
	}

	/**
	 * 归并排序
	 * @param nums
	 * @return
	 */
	public int reversePairs1(int[] nums) {
		int len = nums.length;

		if (len < 2) {
			return 0;
		}

		int[] copy = new int[len];
		for (int i = 0; i < len; i++) {
			copy[i] = nums[i];
		}

		int[] temp = new int[len];
		return reversePairs(copy, 0, len - 1, temp);
	}

	/**
	 * nums[left...right] 计算逆序对个数并且排序
	 * @param nums
	 * @param left
	 * @param right
	 * @param temp
	 * @return
	 */
	private int reversePairs(int[] nums, int left, int right, int[] temp) {
		if (left == right) {
			return 0;
		}
		int mid = left + (right - left) / 2;
		int leftPairs = reversePairs(nums, left, mid, temp);
		int rightPairs = reversePairs(nums, mid + 1, right, temp);
		// 已经是排序数组了
		if (nums[mid] <= nums[mid + 1]) {
			return leftPairs + rightPairs;
		}
		int crossPairs = mergeAndCount(nums, left, mid, right, temp);
		return leftPairs + rightPairs + crossPairs;
	}

	/**
	 * nums[left...mid] 有序  nums【mid+1 .. right】有序
	 * @param nums
	 * @param left
	 * @param mid
	 * @param right
	 * @param temp
	 * @return
	 */
	private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
		for (int i = left; i <= right; i++) {
			temp[i] = nums[i];
		}
		int i = left, j = mid + 1;
		int count = 0;

		for (int k = left; k <= right; k++) {
			if (i == mid + 1) {
				nums[k] = temp[j];
				j++;
			} else if (j == right + 1) {
				nums[k] = temp[i];
				i++;
			} else if (temp[i] <= temp[j]) {
				nums[k] = temp[i];
				i++;
			} else {
				nums[k] = temp[j];
				j++;
				count += (mid - i + 1);
			}
		}
		return count;
	}

}
