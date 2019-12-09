package com.hy.demo.dataStructure.list;

/**
 * Created by wanghai on 2018/12/3.
 */
public class SingleLinkedList {

    public ListNode head;

    public int size;

    public SingleLinkedList() {
        head = null;
        size = 0;
    }

    public SingleLinkedList(int[] a) {
        for (int i = 0; i < a.length; i++) {
          ListNode newHead = new ListNode(a[i]);
          if (size == 0) {
              head = newHead;
          } else {
              newHead.next = head;
              head = newHead;
          }
          size++;
        }
    }


    /**
     * 向头结点添加元素
     * @param data
     * @return
     */
    public Object addHead(int data) {
        ListNode newHead = new ListNode(data);
        if (size == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head  = newHead;
        }
        size++;
        return data;
    }

    /**
     * 在链表头删除元素
     * @return
     */
    public Object deleteHead() {
        Object data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public boolean removeNthFromEnd(int n) {
        if (n > size || n < 1) {
            return false;
        }
        if (n == size) {
            head = head.next;
            size--;
            return true;
        }
        ListNode preListNode = head;
        ListNode current = head.next;
        int len = size - n;
        int i = 1;
        while (current != null) {
            if (i == len) {
                preListNode.next = current.next;
                size--;
                return true;
            }
            preListNode = preListNode.next;
            current = current.next;
            i++;
        }
        return true;
    }


    /**
     * 按照节点值查找节点
     * @param data
     * @return
     */
    public ListNode findNode(Object data) {
        ListNode current = head;
        int tempSize = size;
        if (tempSize > 0) {
            if (data.equals(current.data)) {
                return current;
            } else {
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }

    /**
     * 链表是不是有环
     * @return
     */
    public boolean isLoopList() {
        ListNode slowPoint,fastPoint;
        slowPoint = fastPoint = head;
        while (fastPoint != null && fastPoint.next != null) {
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
            if (slowPoint == fastPoint) {
                return true;
            }
        }
        return false;
    }

    /**
     * 反转链表
     * @return
     */
    public ListNode reverseList() {
        ListNode reverseHead = null;
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode nextListNode = current.next;
            if (nextListNode == null) {
                reverseHead = current;
            }
            current.next = prev;
            prev = current;
            current = nextListNode;
        }
        return reverseHead;
    }

    /**
     * 显示链表
     */
    public void display() {
        if (size > 0) {
            ListNode listNode = head;
            int tempSize = size;
            if (tempSize == 1) {
                System.out.print("[" + listNode.data + "]");
            }
            while (tempSize > 0) {
                if (listNode.equals(head)) {
                    System.out.print("[" + listNode.data + "->");
                } else if (listNode.next == null) {
                    System.out.print(listNode.data + "]");
                } else {
                    System.out.print(listNode.data + "->");
                }
                listNode = listNode.next;
                tempSize--;
            }
        } else {
            System.out.print("[]");
        }
    }

}
