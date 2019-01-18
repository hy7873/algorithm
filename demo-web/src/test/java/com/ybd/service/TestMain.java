package com.ybd.service;

import com.zhongying.demo.algorithm.sort.BubbleSort;
import com.zhongying.demo.algorithm.sort.InsertSort;
import com.zhongying.demo.algorithm.sort.QuickSort;
import com.zhongying.demo.dataStructure.list.SingleLinkedList;
import com.zhongying.demo.dataStructure.list.TwoWayLinkedList;
import com.zhongying.demo.dataStructure.node.Node;
import com.zhongying.demo.dataStructure.tree.BinarySortTree;
import com.zhongying.demo.util.JacksonUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/11/15.
 */
public class TestMain {

    @Test
    public void test1() {
        int[] a = {2,3,5,1,8,-1,-9};
        a = BubbleSort.bubbleSort(a);
        System.out.println(JacksonUtil.bean2Json(a));
    }

    @Test
    public void test2() {
        int[] a = {2,3,5,1,8,-1,-9};
        QuickSort.quickSort(a,0,a.length - 1);
        System.out.println(JacksonUtil.bean2Json(a));
    }

    @Test
    public void test3() {
       /*int[] a = {2,3,5,1,8,-1,-9,17,201,-100};
        InsertSort.insertSort2(a);
        System.out.println(JacksonUtil.bean2Json(a));*/
        double str=0.1212;
        System.out.printf(String.format("%.2f"));
    }


    @Test
    public void test4() {
        int[] arr = {3,4,6,1,2,10,100};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            binarySortTree.add(node);
        }
        binarySortTree.midShow();
        System.out.println(binarySortTree.search(2));
        System.out.println(binarySortTree.max()  + "  " + binarySortTree.min());
        binarySortTree.delete(100);
        binarySortTree.midShow();
        binarySortTree.delete(1);
        binarySortTree.midShow();
        binarySortTree.delete(4);
        binarySortTree.midShow();
    }


    @Test
    public void test5() {
        int[] a = {4,2,1,5,7,11,3};
        SingleLinkedList singleLinkedList = new SingleLinkedList(a);
        singleLinkedList.display();
    }

    @Test
    public void test6() {
        int[] a = {4,2,1,5,7,11,3};
        TwoWayLinkedList twoWayLinkedList = new TwoWayLinkedList(a);
        twoWayLinkedList.display();
    }

    private long fiboFunc(int n) {
        long[] a = new long[n + 1];
        a[1] = 1;
        a[2] = 1;
        for (int i = 3; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }

    @Test
    public void test7() {
        System.out.println(fiboFunc(80));
    }

}
