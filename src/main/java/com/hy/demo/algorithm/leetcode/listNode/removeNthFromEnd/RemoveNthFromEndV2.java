package com.hy.demo.algorithm.leetcode.listNode.removeNthFromEnd;


import com.hy.demo.dataStructure.list.SingleLinkedList;

/**
 * @Author: wanghai
 * @Date:2019/12/4 19:32
 * @Copyright:reach-life
 * @Description:
 */
public class RemoveNthFromEndV2 {

   static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode removeNthFromEnd(ListNode head,int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHead(1);
        singleLinkedList.addHead(2);
        singleLinkedList.addHead(3);
        singleLinkedList.addHead(4);
        singleLinkedList.display();
        singleLinkedList.removeNthFromEnd(4);
        System.out.println();
        singleLinkedList.display();
        System.out.println();
    }

}
