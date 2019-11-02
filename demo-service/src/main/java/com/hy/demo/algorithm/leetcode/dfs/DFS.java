package com.hy.demo.algorithm.leetcode.dfs;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/10/27 10:50
 * @Copyright:reach-life
 * @Description:求一组数的全排列
 */
public class DFS {

   static List<List<Integer>> lists = new ArrayList<>();

    public static List<List<Integer>> dfs(List<Integer> list,String prefix,int size) {
        if (prefix.length() > 0) {
            String[] a = prefix.split(",");
            List<Integer> prefixList = new ArrayList<>();
            if (a.length >= size) {
                for (int i = 0; i < a.length; i++) {
                    prefixList.add(Integer.parseInt(a[i]));
                }
                lists.add(prefixList);
                //System.out.println(new Gson().toJson(prefixList));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = new ArrayList<>(list);
            int item = temp.remove(i);
            dfs(temp,prefix + item + ",",size);
        }
        return lists;
    }


    public static void diStringMatch(String s) {
        List<Integer> originList = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            originList.add(i);
        }
        List<List<Integer>> lists = dfs(originList,"",originList.size());
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> itemList = lists.get(i);
            boolean b = true;
            for (int j = 0; j < itemList.size() - 1; j++) {
                if (s.charAt(j) == 'I') {
                    if (itemList.get(j) >= itemList.get(j + 1)) {
                        b = false;
                    }
                }
                if (s.charAt(j) == 'D') {
                    if (itemList.get(j) <= itemList.get(j + 1)) {
                        b = false;
                    }
                }
            }
            if (b) {
                System.out.println(new Gson().toJson(itemList));
            }
        }
    }

    public static void main(String[] args) {
       /* List<Integer> list = Arrays.asList(1,2,3,5);
        List<List<Integer>> lists2 = dfs(list,"",list.size());
        System.out.println(new Gson().toJson(lists2));*/
       diStringMatch("DDI");
    }



}
