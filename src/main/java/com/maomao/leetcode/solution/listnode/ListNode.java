package com.maomao.leetcode.solution.listnode;

/**
 * @author fujie.feng
 * @Date 2020-03-23
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        this.val = x;
    }

    /**
     * 将数组转链表
     * @param nums
     */
    public ListNode(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException("arr param is null");
        this.val = nums[0];
        ListNode curr = this;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while (curr != null) {
            sb.append(curr.val).append(" -> ");
            curr = curr.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
