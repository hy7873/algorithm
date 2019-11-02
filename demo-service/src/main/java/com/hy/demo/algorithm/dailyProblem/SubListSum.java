package com.hy.demo.algorithm.dailyProblem;

import com.google.gson.Gson;

import java.util.*;

/**
 * @Author: wanghai
 * @Date:2019/3/1 15:27
 * @Copyright:reach-life
 * @Description:
 */
public class SubListSum {

    public static Set<Integer> getSubListSum(List<Integer> list) {
        Set<Integer> listSum = new HashSet<>();
        List<List<Integer>> lists = SubList.getSubset(list);
        for (int i = 0; i < lists.size(); i++) {
            listSum.add(getListSum(lists.get(i)));
        }
        return listSum;
    }


    public static int getListSum(List<Integer> list) {
        int b = 0;
        for (int i = 0; i < list.size(); i++) {
            b += list.get(i);
        }
        return b;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,10);
        Set<Integer> integerSet = getSubListSum(list);
        System.out.println(new Gson().toJson(integerSet));

    }


    public static List<List<Integer>> getSubset(List<Integer> L) {
        List<List<Integer>> lists = new ArrayList<>();
        if (L == null || L.size() == 0) {
            return null;
        }
        for (int i = 0; i < Math.pow(2,L.size()); i++) {
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            int index = i;
            for (int j = 0; j < L.size();j++) {
                if ((index & 1) == 1){
                    list.add(L.get(j));
                    sum += L.get(j);
                }
                index >>= 1;
            }
            lists.add(list);
        }
        return lists;
    }

}
