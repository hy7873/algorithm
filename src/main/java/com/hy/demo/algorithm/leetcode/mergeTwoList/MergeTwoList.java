package com.hy.demo.algorithm.leetcode.mergeTwoList;

import com.hy.demo.dataStructure.list.ListNode;

/**
 * @Author: wanghai
 * @Date:2019/12/9 11:25
 * @Copyright:reach-life
 * @Description:
 */
public class MergeTwoList {

    public static ListNode mergeTwoList(ListNode l1,ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.data < l2.data) {
            l1.next = mergeTwoList(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = initListNode(1,2,3,4);
        ListNode l2 = initListNode(1,3,5,7);
        ListNode l3 = mergeTwoList(l1,l2);
        printListNode(l3);
    }

    public static ListNode initListNode(int ... data) {
        ListNode head = null;
        if (data == null) {
            return head;
        }
        head = new ListNode(data[0]);
        if (data.length == 1) {
            return head;
        }
        head.next = new ListNode(data[1]);
        ListNode t = head.next;
        for (int i = 2; i < data.length; i++) {
            t.next = new ListNode(data[i]);
            t = t.next;
        }
        return head;
    }


    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println();

    }


}
