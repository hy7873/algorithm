package com.hy.service;

import com.hy.demo.algorithm.sort.BubbleSort;
import com.hy.demo.algorithm.sort.QuickSort;
import com.hy.demo.dataStructure.list.SingleLinkedList;
import com.hy.demo.dataStructure.list.TwoWayLinkedList;
import com.hy.demo.dataStructure.node.Node;
import com.hy.demo.dataStructure.tree.BinarySortTree;
import com.hy.demo.util.JacksonUtil;
import com.hy.demo.util.RandomUtil;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.*;

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
    public void test7() throws UnsupportedEncodingException {
        //System.out.println(fiboFunc(80));
        String s = "王";
        byte[] a = s.getBytes("gb2312");
        System.out.println(a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


    public static final Random rn = new Random();

    @Test
    public void test11() {
        List<String> list = new ArrayList<>();
        for (String s : list) {
            System.out.println(s);
        }
    }

    static int random(int n) {
        return Math.abs(rn.nextInt()) % n;
    }

    @Test
    public void test21() {
        int n = 2 * (Integer.MAX_VALUE/3);
        int low = 0;
        for (int i = 0 ; i < 1000000 ; i++) {
            if (random(n) <= n/2) {
                low ++;
            }
        }
        System.out.println(low);
    }

    @Test
    public void test31() {
        /**
         * Integer.MIN_VALUE取绝对值还是本身
         * 原因：int范围是-2147483648 : 2147483647
         * 2147483648超出了int表示的范围了
         */
        int n = Math.abs(Integer.MIN_VALUE);
        System.out.println(n);
        System.out.println(Integer.MIN_VALUE < 0);
        System.out.println(-1 * Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE + " : " + Integer.MAX_VALUE);
        Long l =Long.parseLong(String.valueOf(-1 * Integer.MIN_VALUE));
        System.out.println(Long.MIN_VALUE + " : " + Long.MAX_VALUE);

    }


    @Test
    public void test41() {
        int i = 0;
        int k = 0;
        long startTime = System.currentTimeMillis();
        while (true) {
            i++;
            long endTime = System.currentTimeMillis();
            if (endTime - startTime == 1000) {
                k++;
                System.out.println("结果 : " + i + " 次数 : "+k);
                break;
            }
        }
    }



    @Test
    public void testRandomStr() {
        Set<String> set = new HashSet<>();
        String randomStr = "";
        int duplicateCnt = 0;
        for (int i = 0; i < 10000000; i++) {
            randomStr = RandomUtil.getRandomStrV2(15);
            if (set.contains(randomStr)) {
                duplicateCnt++;
            }
            set.add(randomStr);
        }
        System.out.println(String.format("总个数%s，重复的个数%s",set.size(),duplicateCnt));
    }


    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String s = sc.next();
        long l = Long.parseLong(s);
        long k = l / 2;
        long startTime = System.currentTimeMillis();
        for (long i=0;i < l;i ++ ) {
            if (i == k) {
                long endTime = System.currentTimeMillis();
                System.out.println("结果 ： " + i + "时间 ：" + (endTime - startTime));
            }
        }
    }

}
