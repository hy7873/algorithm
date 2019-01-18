package com.hy.demo.dataStructure.node;

/**
 * Created by Administrator on 2018/11/21.
 */
public class Node {

    public int value;

    public Node left;

    public Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 新增节点
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     * @param node
     */
    public void midShow(Node node) {
        if (node == null) {
            return;
        }
        midShow(node.left);
        System.out.println(node);
        midShow(node.right);
    }


    /**
     * 查找
     * @param value
     * @return
     */
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (this.value < value) {
            if (right == null) {
                return null;
            }
            return right.search(value);
        } else {
            if (left == null) {
                return null;
            }
            return left.search(value);
        }
    }


    public Node getMin(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return getMin(node.left);
        }
    }

    public Node getMax(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return getMax(node.right);
        }
    }

    public Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }


    public Node delete(Node node,int value) {
        if (node == null) {
            return null;
        }
        if (value < node.value) {
            node.left = delete(node.left,value);
        } else if (value > node.value) {
            node.right = delete(node.right,value);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node t = node;
            node = getMin(t.right);
            node.right =deleteMin(t.right);
            node.left = t.left;
        }
        return node;
    }


    @Override
    public String toString() {
        return "["+this.hashCode()+ "|" +this.value+ "]";
    }
}
