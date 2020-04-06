package com.maomao.leetcode.solution.listnode;

/**
 * @author fujie.feng
 * @Date 2020-04-06
 */
public class MergeTwoListsSolution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode head = temp;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 == null) {
            head.next = l2;
        }
        if (l2 == null) {
            head.next = l1;
        }
        return temp.next;
    }


    public static void main(String[] args) {
        MergeTwoListsSolution merge = new MergeTwoListsSolution();
        ListNode l1 = new ListNode(new int[]{1,2,4});
        ListNode l2 = new ListNode(new int[]{1,3,4});

        System.out.println(merge.mergeTwoLists(l1, l2));
    }
}
