package com.hy.demo.algorithm.dailyProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/2/22 10:46
 * @Copyright:reach-life
 * @Description:稀疏数
 * 我们说一个数是稀疏的，如果在它的二进制表示中没有相邻的数。例如，21（10101）是稀疏的，但22（10110）不是。对于给定的输入n，找到大于或等于n的最小稀疏数
 */
public class SparseNumber {

    public static int getMinSparseNumber(int n) {
        while (true) {
            if (isSparseNumber(n)) {
               return n;
            }
            n++;
        }
    }

    public static boolean isSparseNumber(int n) {
        List<Integer> list = getBinaryFromNumberV2(n);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == list.get( i + 1)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 十进制转化为二进制
     * @param n
     * @return
     */
    public static List<Integer> getBinaryFromNumber(int n) {
        List<Integer> list = new ArrayList<>();
        while (true) {
            int k = n % 2;
            list.add(k);
            n = n / 2;
            if (n < 2) {
                list.add(n);
                break;
            }
        }
        Collections.reverse(list);
        System.out.println(list);
        return list;
    }

    /**
     * 十进制转化为二进制
     * @param n
     * @return
     */
    public static List<Integer> getBinaryFromNumberV2(int n) {
        List<Integer> list = new ArrayList<>();
        boolean flag = false;
        for (int i = 31; i >= 0 ; i--) {
            int k = n >>> i & 1;
            if (k != 0 && !flag) {
                flag = true;
            }
            if (flag) {
                list.add(k);
            }
        }
        System.out.println(list);
        return list;
    }


    public static int[] getBinaryFromNumberV3(int n) {
        int[] a = new int[32];
        boolean flag = false;
        for (int i = 31; i >= 0 ; i--) {
            int k = n >>> i & 1;
            a[i] = k;
        }
        System.out.println(a);
        return a;
    }



    public static void main(String[] args) {
        //System.out.println(getMinSparseNumber(4));;
        for (int i = 1; i <= 100; i++) {
            if (i == (i&(i + 1))) {
                System.out.println(i);
            }
        }
    }

}
