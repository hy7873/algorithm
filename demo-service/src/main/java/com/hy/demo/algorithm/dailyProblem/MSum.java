package com.hy.demo.algorithm.dailyProblem;

import com.google.gson.Gson;
import com.hy.demo.algorithm.leetcode.dfs.DFS;
import com.rabbitmq.tools.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/11/6 13:06
 * @Copyright:reach-life
 * @Description:
 */
public class MSum {

    public static List<List<Integer>> getMSumList(int m,int n) {
        int[] array = new int[n];
        List<List<Integer>> retList = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            array[i-1] = i;
        }
        for (int i = 1; i <= n ; i++) {
            List<List<Integer>> dfsList = new ArrayList<>();
             DFS.combine(0,i,array,dfsList);
            for (int j = 0; j < dfsList.size(); j++) {
                List<Integer> itemList = dfsList.get(j);
                int sum = itemList.stream().mapToInt(Integer::intValue).sum();
                if (sum == m) {
                    retList.add(itemList);
                }
            }
        }
        return retList;
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(getMSumList(10,5)));
    }

}
