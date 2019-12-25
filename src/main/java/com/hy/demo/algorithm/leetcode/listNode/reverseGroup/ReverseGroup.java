package com.hy.demo.algorithm.leetcode.listNode.reverseGroup;

import com.hy.demo.dataStructure.list.ListNode;

import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/12/23 19:47
 * @Copyright:reach-life
 * @Description:
 */
public class ReverseGroup {

    public static ListNode reverseGroup(ListNode head,int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }


    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.initListNode(1,2,3,4,5);
        ListNode.printListNode(reverseGroup(head,5));
    }

}
