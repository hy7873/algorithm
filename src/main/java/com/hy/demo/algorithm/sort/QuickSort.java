package com.hy.demo.algorithm.sort;

/**
 * 快排序
 * Created by Administrator on 2018/11/15.
 */
public class QuickSort {

    public static void quickSort(int[] a,int low,int high) {
        int start = low;
        int end = high;
        int key = a[low];
       while (end > start) {
           while (end > start && a[end] >= key) {
               end--;
           }
           if (a[end] <= key) {
               int temp = a[end];
               a[end] = a[start];
               a[start] = temp;
           }
           while (end > start && a[start] <= key) {
               start++;
           }
           if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
           }
       }
       if (start > low) {
           quickSort(a,low,start - 1);
       }
       if (end < high) {
           quickSort(a,end + 1,high);
       }
    }




}
