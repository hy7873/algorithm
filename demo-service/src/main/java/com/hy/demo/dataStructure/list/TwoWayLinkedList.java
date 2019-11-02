package com.hy.demo.dataStructure.list;

/**
 * Created by Administrator on 2018/12/4.
 */
public class TwoWayLinkedList {

    private Node head;

    private Node tail;

    private int size;

    private class Node {

        private Object data;

        private Node prev;

        private Node next;

        public Node(Object data) {
            this.data = data;
        }

    }


    public TwoWayLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public TwoWayLinkedList(int[] a){
        for (int i = 0; i < a.length; i++) {
            Node node = new Node(a[i]);
            if (size == 0) {
                head = node;
                tail = node;
                size++;
            } else {
                node.prev = tail;
                tail.next = node;
                tail = node;
                size++;
            }
        }
    }

    /**
     * 从头部添加
     * @param data
     */
    public void addHead(Object data) {
        Node node = new Node(data);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
            size++;
        }
    }


    /**
     * 从尾部添加
     * @param data
     */
    public void addTail(Object data) {
        Node node = new Node(data);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
            size++;
        }
    }



    /**
     * 删除头部
     * @return
     */
    public Node deleteHead() {
        Node temp = head;
        if (size != 0) {
            head = head.next;
            head.prev = null;
            size--;
        }
        return temp;
    }


    /**
     * 删除尾部
     * @return
     */
    public Node deleteTail() {
        Node temp = tail;
        if (size != 0) {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
        return temp;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * 显示所有节点
     */
    public void display() {
        if (size > 0) {
            Node node = head;
            int tempSize = size;
            if (tempSize == 1) {
                System.out.print("[" + node.data + "]");
                return;
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
