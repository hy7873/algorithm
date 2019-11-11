package com.hy.demo.algorithm.leetcode.reverseNumber;


import java.util.Arrays;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/11/9 9:11
 * @Copyright:reach-life
 * @Description:
 */
public class ReverseNumber {

    public static long reverseNumber(long number) {
        String numberStr = number + "";
        char[] chars = numberStr.toCharArray();
        int len = chars.length;
        char temp;
        char[] charsRet = new char[len];
        for (int i = 0; i < len ; i++) {
            charsRet[i] = chars[len - i - 1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len ; i++) {
            sb.append(charsRet[i]);
        }
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(reverseNumber(1314));
    }

}
