package com.hy.demo.algorithm.leetcode.atoi;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/11/10 17:10
 * @Copyright:reach-life
 * @Description:字符串转数字
 */
public class Atoi {

    public static int atio(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        int len = s.length();
        int start = 0;
        char firstChar = s.charAt(start);
        boolean negative = false;
        if (firstChar < '0') {
            if (firstChar == '-') {
                negative = true;
            } else if (firstChar != '+') {
                return 0;
            }
            start++;
        }
        int ans = 0;
        for (int i = start; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                //Integer.MAX_VALUE/Integer.MIN_VALUE最后一位数不同
                //正数
                if (!negative && (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && c > '7'))) {
                    return Integer.MAX_VALUE;
                }
                //负数
                if (negative && (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && c > '8'))) {
                    return Integer.MIN_VALUE;
                }
                ans = ans * 10 + c - '0';
            } else {
                return negative ? -1 * ans : ans;
            }
        }
        return negative ? -1 * ans : ans;
    }
    public static void main(String[] args) {
        System.out.println(atio("-91283472332"));
    }
}
