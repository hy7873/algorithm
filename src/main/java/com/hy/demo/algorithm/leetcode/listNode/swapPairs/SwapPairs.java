package com.hy.demo.algorithm.leetcode.listNode.swapPairs;

import com.hy.demo.dataStructure.list.ListNode;

/**
 * @Author: wanghai
 * @Date:2019/12/21 13:27
 * @Copyright:reach-life
 * @Description:
 */
public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.initListNode(1,2,3,4);
        ListNode.printListNode(swapPairs(head));
    }

}
