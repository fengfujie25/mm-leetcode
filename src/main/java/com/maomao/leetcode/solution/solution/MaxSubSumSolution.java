package com.maomao.leetcode.solution.solution;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

 * @auther fujie.feng
 * @Date 2020-01-17
 */
public class MaxSubSumSolution {

    /**
     * 贪心算法
     *
     * 使用单个数组作为输入来查找最大（或最小）元素（或总和）的问题，贪心算法是可以在线性时间解决的方法之一。
     * 每一步都选择最佳方案，到最后就是全局最优的方案。
     * 算法：
     * 该算法通用且简单：遍历数组并在每个步骤中更新：
     *
     * 当前元素
     * 当前元素位置的最大和
     * 迄今为止的最大和
     *
     *
     * 复杂度分析
     *
     * 时间复杂度：\mathcal{O}(N)O(N)。只遍历一次数组。
     * 空间复杂度：\mathcal{O}(1)O(1)，只使用了常数空间。
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    /**
     * 动态规划（Kadane 算法）
     * 算法：
     *
     * 在整个数组或在固定大小的滑动窗口中找到总和或最大值或最小值的问题可以通过动态规划（DP）在线性时间内解决。
     * 有两种标准 DP 方法适用于数组：
     * 常数空间，沿数组移动并在原数组修改。
     * 线性空间，首先沿 left->right 方向移动，然后再沿 right->left 方向移动。 合并结果。
     *
     * 我们在这里使用第一种方法，因为可以修改数组跟踪当前位置的最大和。
     * 下一步是在知道当前位置的最大和后更新全局最大和。
     *
     * 复杂度分析
     *
     * 时间复杂度：\mathcal{O}(N)O(N)。只遍历了一次数组。
     * 空间复杂度：\mathcal{O}(1)O(1)，使用了常数的空间。
     *
     * @param nums
     * @return
     */
    public static int dpMaxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, -1, 3, 3, 5, 6, -7};
        System.out.println(MaxSubSumSolution.maxSubArray(nums));
        System.out.println(MaxSubSumSolution.dpMaxSubArray(nums));
    }
}
