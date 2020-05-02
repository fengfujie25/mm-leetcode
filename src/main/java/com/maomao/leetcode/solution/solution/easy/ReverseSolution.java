package com.maomao.leetcode.solution.solution.easy;

/**
 *  整数反转
 *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @auther: fujie.feng
 * @DateT: 2020-01-16
 */
public class ReverseSolution {

    public static int reverse(int x) {
        int reverse = 0;
        while(x != 0) {
            int pop = x % 10;
            x /= 10;

            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            reverse = reverse * 10 + pop;
        }
        return reverse;
    }


    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
//        int x = 345;
//        System.out.println(ReverseSolution.reverse(x));

        int[] nums = new int[]{1};
        System.out.println(ReverseSolution.maxSubArray(nums));
    }
}
