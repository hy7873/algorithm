package com.hy.demo.algorithm.leetcode.longestCommonPrefix;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wanghai
 * @Date:2019/11/24 17:28
 * @Copyright:reach-life
 * @Description:
 */
public class LongestCommonPrefix {

    public static String getLongestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        if (strs.length == 0) {
            return ans.toString();
        }
       label: for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length ; j++) {
                if (strs[j].length() > i && c == strs[j].charAt(i)) {
                    if (j == strs.length - 1) {
                        ans.append(c);
                    } else {
                        continue;
                    }
                } else {
                    continue label;
                }
            }
        }
        return ans.toString();
    }

    /**
     *
     * @param strs
     * @return
     * @desc
     * 1、令公共字符串为第一个字符串；
     * 2、两两对比然后找出公共;
     * 3、如果公共字符为空，直接返回。
     */
    public static String getLongestCommonPrefixV2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 0; i < strs.length ; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length() ; j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                if (ans.equals("")) {
                    return ans;
                }
            }
            ans = ans.substring(0,j);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"dsaogsssssss","dsiaracecar","dscar"};
        System.out.println(getLongestCommonPrefixV2(strs));
    }
}
