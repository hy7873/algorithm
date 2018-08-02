package com.ybd.algorithm;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 *
 Good morning! Here's your coding interview problem for today.

 This problem was asked by Amazon.

 Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

 For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".

 Upgrade to premium and get in-depth solutions to every problem.

 If you liked this problem, feel free to forward it along so they can subscribe here! As always, shoot us an email if there's anything we can help with!
 */
public class DailyProblem_13 {


    @Test
    public void test1() {
        String s = "abcba";
        String longestString = "";
        String subString = "";
        for (int i = 0;i < s.length() ; i++) {
            for (int j = i + 1;j < s.length() ; j++) {
                subString = s.substring(i,j);
                if (haveKDiffStr(subString,2) && subString.length() > longestString.length()) {
                    longestString = subString;
                }
            }
        }
        System.out.println("test1 = " + longestString);
    }

    private boolean haveKDiffStr(String str,int k) {
        Set<Character> characterSet = new HashSet<>();
        if (str.length() >= k) {
            char[] chars = str.toCharArray();
            for (int i = 0;i < chars.length ; i++) {
                characterSet.add(chars[i]);
            }
            if (characterSet.size() == k) {
                return true;
            }
        }
        return false;
    }





}
