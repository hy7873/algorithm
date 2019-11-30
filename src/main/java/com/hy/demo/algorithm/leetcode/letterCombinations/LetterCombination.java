package com.hy.demo.algorithm.leetcode.letterCombinations;

import com.google.gson.Gson;

import java.util.*;

/**
 * @Author: wanghai
 * @Date:2019/11/30 10:08
 * @Copyright:reach-life
 * @Description:
 */
public class LetterCombination {

    private static Map<Integer,List<Character>> initData = new HashMap<>();

    private static List<String> ans = new ArrayList<>();

    static {
        initData.put(2, Arrays.asList('a','b','c'));
        initData.put(3, Arrays.asList('d','e','f'));
        initData.put(4, Arrays.asList('g','h','i'));
        initData.put(5, Arrays.asList('j','k','l'));
        initData.put(6, Arrays.asList('m','n','o'));
        initData.put(7, Arrays.asList('p','q','r','s'));
        initData.put(8, Arrays.asList('t','u','v'));
        initData.put(9, Arrays.asList('w','x','y','z'));
    }





    public static void backStrack(String combination,String digits) {
        if (digits.length() == 0) {
            ans.add(combination);
        } else {
            String digit = digits.substring(0,1);
            List<Character> characterList = initData.get(Integer.parseInt(digit));
            for (int i = 0; i < characterList.size(); i++) {
                String letter = characterList.get(i) + "";
                backStrack(letter + combination,digits.substring(1));
            }
        }
    }

    public static List<String> letterCombination(String digits) {
        if (digits.length() != 0) {
            backStrack("",digits);
        }
        return ans;
    }

    public static void main(String[] args) {
        letterCombination("22");
        System.out.println(new Gson().toJson(ans));
    }

}
