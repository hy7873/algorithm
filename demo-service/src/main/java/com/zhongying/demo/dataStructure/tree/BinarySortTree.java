package com.zhongying.demo.dataStructure.tree;

import com.zhongying.demo.dataStructure.node.Node;

/**
 * 二叉排序树
 * Created by Administrator on 2018/11/21.
 */
public class BinarySortTree {

    private Node root;

    public void add(Node node) {
        if (node == null) {
            return;
        }
        //空树
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void midShow() {
        if (root != null) {
            root.midShow(root);
        }
        System.out.println("--------------------------------");
    }

    /**
     * 查找
     * @param value
     * @return
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 获取最小
     * @return
     */
    public Node min() {
        if (root == null) {
            return null;
        }
        return root.getMin(root);
    }


    /**
     * 获取最大
     * @return
     */
    public Node max() {
        if (root == null) {
            return null;
        }
        return root.getMax(root);
    }


    /**
     * 删除
     * @param value
     */
    public void delete(int value) {
        root.delete(root,value);
    }






}
