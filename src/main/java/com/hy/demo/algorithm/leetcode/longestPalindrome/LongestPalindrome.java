package com.hy.demo.algorithm.leetcode.longestPalindrome;

/**
 * @Author: wanghai
 * @Date:2019/11/7 13:24
 * @Copyright:reach-life
 * @Description:
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "bbdbbddc";
        System.out.println(getLongestPalindrome(s));
        System.out.println(getLongestPalindromeForce(s));
    }

    /**
     * force-method
     * @param s
     * @return
     */
    public static String getLongestPalindromeForce(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0,1);
        for (int i = 0; i < len - 1 ; i++) {
            for (int j = i + 1; j < len ; j++) {
                if (j - i + 1 > maxLen && validPalind(s,i,j)) {
                    maxLen = j - i + 1;
                    res = s.substring(i,j + 1);
                }
            }
        }
        return res;
    }

    public static boolean validPalind(String s,int start,int end) {
        int len = s.length();
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }



    /**
     * Manacher
     * @param s
     * @return
     */
    public static String getLongestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        String str = addBoundaries(s,'#');
        System.out.println(str);
        int sLen = 2 * len + 1;
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < sLen ; i++) {
            int currLen = centerSpread(str,i);
            if (currLen > maxLen) {
                maxLen = currLen;
                start = (i - maxLen)/2;
            }
        }
        return s.substring(start,start + maxLen);
    }


    private static String addBoundaries(String s,char divide) {
        int length = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(divide).append(s.charAt(i));
        }
        stringBuilder.append(divide);
        return stringBuilder.toString();
    }

    private static int centerSpread(String s,int center) {
        int length = s.length();
        int i = center - 1;
        int j = center + 1;
        int step = 0;
        while (i >= 0 && j < length && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            step++;
        }
        return step;
    }

}
