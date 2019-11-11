package com.hy.demo.algorithm.leetcode.dfs;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/10/27 10:50
 * @Copyright:reach-life
 * @Description:求一组数的全排列
 */
public class DFS {

    public static List<List<Integer>> dfs(List<Integer> list,String prefix,int size,List<List<Integer>> lists) {
        if (prefix.length() > 0) {
            String[] a = prefix.split(",");
            List<Integer> prefixList = new ArrayList<>();
            if (a.length == size) {
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
            dfs(temp,prefix + item + ",",size,lists);
        }
        return lists;
    }


    public static void diStringMatch(String s) {
        List<Integer> originList = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            originList.add(i);
        }
        List<List<Integer>> lists = new ArrayList<>();
        dfs(originList,"",originList.size(),lists);
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
        //List<Integer> list = Arrays.asList(1,2,3);
        //List<List<Integer>> lists2 = dfs(list,"",2);
        //System.out.println(new Gson().toJson(lists2));
        //diStringMatch("DDI");
        int[] array = {1,2,3,4};
        List<List<Integer>> retList = new ArrayList<>();
        combine(0,1,array,retList);
        System.out.println(new Gson().toJson(retList));
    }

    static List<Integer> tempArr = new ArrayList<>();

    public static void combine(int index,int k,int[] array,List<List<Integer>> retList) {
        if (k == 1) {
            for (int i = index; i < array.length ; i++) {
                tempArr.add(array[i]);
                List<Integer> itemList = new ArrayList<>();
                itemList.addAll(tempArr);
                retList.add(itemList);
                tempArr.remove((Object)array[i]);//是删除元素，不是索引
            }
        } else if (k > 1) {
            for (int i = index; i <= array.length - k ; i++) {
                tempArr.add(array[i]);
                combine(i + 1,k - 1,array,retList);
                tempArr.remove((Object)array[i]);////是删除元素，不是索引
            }
        } else {
            return;
        }
    }



}
