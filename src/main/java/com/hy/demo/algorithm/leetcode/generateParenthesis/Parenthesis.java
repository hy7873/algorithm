package com.hy.demo.algorithm.leetcode.generateParenthesis;

import com.google.gson.Gson;
import sun.security.krb5.internal.crypto.HmacSha1Aes128CksumType;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/12/13 11:22
 * @Copyright:reach-life
 * @Description:
 */
public class Parenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans,"",0,0,n);
        return ans;
    }

    public static void backtrack(List<String> ans,String cur,int open,int close,int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (open < max) {
            backtrack(ans,cur + "(",open + 1,close,max);
        }
        if (close < open) {
            backtrack(ans,cur + ")",open,close + 1,max);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(generateParenthesis(3)));
    }

}
