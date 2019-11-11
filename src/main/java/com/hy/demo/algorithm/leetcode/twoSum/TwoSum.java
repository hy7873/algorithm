package com.hy.demo.algorithm.leetcode.twoSum;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wanghai
 * @Date:2019/10/28 11:43
 * @Copyright:reach-life
 * @Description:
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length;i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length;i++) {
            int com = target - nums[i];
            if (map.containsKey(com) && map.get(com) != i) {
                return new int[]{i,map.get(com)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = {2,4,1,5};
        System.out.println(new Gson().toJson(twoSum(a,5)));
    }
}
