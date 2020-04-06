package com.maomao.leetcode.solution.solution;

import java.util.Random;


/**
 *在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

/**
 * @auther: fujie.feng
 * @DateT: 2019-12-17
 */
public class FindKthLargestSolution {

    /**
     * 优先队列方式
     * @param nums
     * @param k
     * @return
     */
//    public static int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//
//        for (int i : nums) {
//            priorityQueue.add(i);
//            if (priorityQueue.size() > k) {
//                priorityQueue.poll();
//            }
//        }
//        return priorityQueue.poll();
//    }

    /**
     * jdk自带的排序：默认快速排序
     * @param nums
     * @param k
     * @return
     */
//    public static int findKthLargest(int[] nums, int k) {
//        int len = nums.length;
//        Arrays.sort(nums);
//        return nums[len - k];
//    }


    /**
     * 快速排序partition方式
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        int leng = nums.length;
        int left = 0;
        int right = leng - 1;
        int target = leng - k;
        return quickSelect(nums, left, right, target);
    }

    /**
     * 排序
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static int quickSelect(int[] nums, int left, int right, int target) {
        if (left == right) {
            return nums[left];
        }
        //随机选择一个
        Random random = new Random();
        int pivot = left + random.nextInt(right - left);

        pivot = partition(nums, left, right, pivot);
        if (target == pivot) {
            return nums[target];
        }
        if (target < pivot) {
            return quickSelect(nums, left, pivot - 1, target);
        }
        return quickSelect(nums, pivot + 1, right, target);
    }

    /**
     * partition切分
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    private static int partition(int[] nums, int left, int right, int target) {
        int pivot = nums[target];
        swap(nums, target, right);
        int j = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, j, i);
                j++;
            }
        }
        swap(nums, j, right);
        return j;
    }

    /**
     * 交换
     * @param nums
     * @param a
     * @param b
     */
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }





}
