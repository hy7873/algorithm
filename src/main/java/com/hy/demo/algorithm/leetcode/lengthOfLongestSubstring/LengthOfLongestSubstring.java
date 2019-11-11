package com.hy.demo.algorithm.leetcode.lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wanghai
 * @Date:2019/11/2 14:01
 * @Copyright:reach-life
 * @Description:
 */
public class LengthOfLongestSubstring {

    /**
     * 暴力法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s,i,j)) {
                    ans = Math.max(ans,j-i);
                }
            }
        }
        return ans;
    }


    public static boolean allUnique(String s,int start,int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character c = s.charAt(i);
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }
        return true;
    }


    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringV2(String s) {
        int n = s.length();
        int i=0,j=0,ans=0;
        Set<Character> set = new HashSet<>();
        while(i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans,j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

}
