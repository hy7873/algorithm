package com.hy.demo.algorithm.quxuesuanfa.divide.conquer;

/**
 * @Author: wanghai
 * @Date:2019/5/2 22:02
 * @Copyright:reach-life
 * @Description: 分治法，分而治之
 */
public class DivideAndConquer {


    /**
     * 折半查找
     * @param s 查找的有序数组
     * @param x 需要查找的数
     * @return 返回所在下标
     */
    public static int binarySearch(int[] s,int x) {
        int low = 0,high = s.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (x == s[middle]) {
                return middle;
            } else if (x < s[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] s = {2,3,4,7,10,20,77};
        System.out.println(binarySearch(s,78));
    }

}
