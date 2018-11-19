package com.zhongying.demo.algorithm.sort;

/**
 * 插入排序
 * Created by wanghai on 2018/11/19.
 */
public class InsertSort {

    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                int temp = a[i];
                int k = i - 1;
                for (int j = k; j >= 0 && temp < a[j] ; j--) {
                    a[j+1] = a[j];
                    k--;
                }
                a[k + 1] = temp;
            }
        }
    }

    public static int[] insertSort2(int[] a) {
        if (a == null || a.length == 1) {
            return a;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

}
