package com.zhongying.demo.algorithm.sort;

import com.google.gson.Gson;

/**
 * Created by wanghai on 2018/11/30.
 * 归并排序
 */
public class MergeSortV2 {


    /**
     *
     * @param c 包含两个有序区间的数组
     * @param s 第一个有序区间的起始
     * @param m 第二个有序区间的起始
     * @param t 其二个有序区间的结束
     */
    public static void merge(int c[],int s,int m,int t) {
        int[] temp = new int[t - s + 1];
        int i = s,j = m + 1,k = 0;
        while (i <= m && j <= t) {
            if (c[i] <= c[j]) {
                temp[k++] = c[i++];
            } else {
                temp[k++] = c[j++];
            }
        }

        while (i <= m) {
            temp[k++] = c[i++];
        }

        while (j <= t) {
            temp[k++] = c[j++];
        }

        for (int l = 0; l < k; l++) {
            c[s + l] = temp[l];
        }
        temp = null;
    }


    /**
     *
     * @param a 需要排序的数组
     * @param s 数组的开始位置
     * @param t 数组的结束位置
     */
    public static void mergeSortUp2Down(int[] a,int s,int t) {
        if (a == null || s >= t ) {
            return;
        }

        int mid = (s + t) / 2;
        mergeSortUp2Down(a,s,mid);
        mergeSortUp2Down(a,mid + 1,t);
        merge(a,s,mid,t);
    }


    public static void main(String[] args) {
        int a[] = {7,8,1,2,11,18,1,0,10};
        mergeSortUp2Down(a,0,a.length - 1);
        System.out.println(new Gson().toJson(a));
    }


}
