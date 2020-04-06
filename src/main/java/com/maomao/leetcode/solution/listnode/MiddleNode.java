package com.maomao.leetcode.solution.listnode;

/**
 * @author fujie.feng
 * @Date 2020-03-23
 */
public class MiddleNode {

    public static ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        ListNode listNode = new ListNode(nums);
        ListNode res = MiddleNode.middleNode(listNode);
        System.out.println(res);
    }
}
