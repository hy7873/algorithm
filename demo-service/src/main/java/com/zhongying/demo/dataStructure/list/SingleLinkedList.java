package com.zhongying.demo.dataStructure.list;

import java.util.Iterator;
import java.util.LinkedList;

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

}
