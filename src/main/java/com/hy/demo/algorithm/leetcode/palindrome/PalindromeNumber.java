package com.hy.demo.algorithm.leetcode.palindrome;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/11/11 10:55
 * @Copyright:reach-life
 * @Description:
 */
public class PalindromeNumber {

    public static boolean isPalindromeNumber(int n) {
        String s = n + "";
        int len = s.length();
        int sLen = 2 * len + 1;
        String newStr = addBoundaries(s,'#');
        for (int i = 0; i < sLen; i++) {
            if (newStr.charAt(i) != newStr.charAt(sLen - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static String addBoundaries(String s,char divide) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(divide);
        for (int i = 0; i < s.length() ; i++) {
            stringBuilder.append(s.charAt(i)).append(divide);
        }
        return stringBuilder.toString();
    }



    public static boolean isPalindromeNumberV2(int n) {
        int origin = n;
        List<Integer> numberList = new ArrayList<>();
        if (n < 10) {
            return true;
        }
        while (true) {
            int mod = n % 10;
            numberList.add(mod);
            n = n / 10;
            if (n < 10) {
                numberList.add(n);
                break;
            }
        }
        int len = numberList.size();
        if (len % 2 == 0) {
            if (origin % 11 == 0) {
                return true;
            } else {
                return false;
            }
        }
        if (len % 2 != 0) {
            for (int i = 0; i < len ; i++) {
                if (numberList.get(i) != numberList.get(len - i -1)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean isPalindromeNumberV3(int n) {
        String s = n + "";
        StringBuilder stringBuilder = new StringBuilder(s);
        StringBuilder reverseStr = stringBuilder.reverse();
        return s.equals(reverseStr.toString());
    }

    public static boolean isPalindromeNumberV4(int n) {
        if (n < 10) {
            return true;
        }
        int div = 1;
        while (n / div >= 10) {
            div = div * 10;
        }
        while (n > 0) {
            int left = n / div;
            int right = n % 10;
            if (left != right) {
                return false;
            }
            n = (n % div) / 10;
            div /=100;
        }
        return true;

    }



    public static void main(String[] args) {
        for (int i = 1; i < 100000 ; i++) {
            if (isPalindromeNumberV4(i) && i % 11 != 0) {
                System.out.println(i);
            }
        }
        System.out.println("no");
        //System.out.println(isPalindromeNumberV4(10201));
    }

}
