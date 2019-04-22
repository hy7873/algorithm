package com.hy.demo.data.structure.list;

/**
 * Created by wanghai on 2018/12/3.
 */
public class SingleLinkedList {

    private Node head;

    private int size;

    public SingleLinkedList() {
        head = null;
        size = 0;
    }

    public SingleLinkedList(int[] a) {
        for (int i = 0; i < a.length; i++) {
          Node newHead = new Node(a[i]);
          if (size == 0) {
              head = newHead;
          } else {
              newHead.next = head;
              head = newHead;
          }
          size++;
        }
    }


    private class Node {
        //节点的数据
        private Object data;
        //节点的下一个节点
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    /**
     * 向头结点添加元素
     * @param data
     * @return
     */
    public Object addHead(Object data) {
        Node newHead = new Node(data);
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


    /**
     * 按照节点值查找节点
     * @param data
     * @return
     */
    public Node findNode(Object data) {
        Node current = head;
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
        Node slowPoint,fastPoint;
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
    public Node reverseList() {
        Node reverseHead = null;
        Node current = head;
        Node prev = null;
        while (current != null) {
            Node nextNode = current.next;
            if (nextNode == null) {
                reverseHead = current;
            }
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return reverseHead;
    }

    /**
     * 显示链表
     */
    public void display() {
        if (size > 0) {
            Node node = head;
            int tempSize = size;
            if (tempSize == 1) {
                System.out.print("[" + node.data + "]");
            }
            while (tempSize > 0) {
                if (node.equals(head)) {
                    System.out.print("[" + node.data + "->");
                } else if (node.next == null) {
                    System.out.print(node.data + "]");
                } else {
                    System.out.print(node.data + "->");
                }
                node = node.next;
                tempSize--;
            }
        } else {
            System.out.print("[]");
        }
    }

}
