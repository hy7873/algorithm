package com.hy.demo.algorithm.leetcode.strStr;

/**
 * @Author: wanghai
 * @Date:2020/1/3 20:06
 * @Copyright:reach-life
 * @Description:
 */
public class StrStr {

    public static int indexOfStr(String haystack,String needle) {
        int n = haystack.length(),m = needle.length();
        char[] hayArr = haystack.toCharArray();
        char[] neeArr = needle.toCharArray();
        for (int i = 0; i < n - m + 1; i++) {
            int j = 0;
            for (; j < m ; j++) {
                if (hayArr[i + j] != neeArr[j]) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = indexOfStr("xxaadd","dc");
        System.out.println(i);
    }

}
