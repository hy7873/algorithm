package com.hy.demo.dataStructure.list;

/**
 * @Author: wanghai
 * @Date:2019/12/9 11:35
 * @Copyright:reach-life
 * @Description:
 */
public class ListNode {
    //节点的数据
    public int data;
    //节点的下一个节点
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
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
