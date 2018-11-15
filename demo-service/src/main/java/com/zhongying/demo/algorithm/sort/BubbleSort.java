package com.zhongying.demo.algorithm.sort;

/**
 * 冒泡排序
 * Created by Administrator on 2018/11/15.
 */
public class BubbleSort {

    public static int[] bubbleSort(int [] a) {
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

}
