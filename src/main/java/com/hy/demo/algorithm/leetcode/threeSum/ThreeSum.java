package com.hy.demo.algorithm.leetcode.threeSum;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/11/28 13:39
 * @Copyright:reach-life
 * @Description:
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(Integer[] nums) {
        List<Integer> numList = Arrays.asList(nums);
        Collections.sort(numList);
        int l,r;
        int len = numList.size();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len ; i++) {
            int num = numList.get(i);
            l = i + 1;
            r = len - 1;
            while (l < r) {
                if (num > 0) {
                    return ans;
                }
                if (num + numList.get(l) + numList.get(r) == 0) {
                    List<Integer> itemList = Arrays.asList(num,numList.get(l),numList.get(r));
                    ans.add(itemList);
                }
                if (i > 1 && numList.get(i) == numList.get(i - 1)) {
                    break;
                }
                if (l + 1 < len && numList.get(l) == numList.get(l + 1)) {
                    l++;
                }
                if (r - 1 > 0 && numList.get(r) == numList.get(r - 1)) {
                    r--;
                }
                l++;
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Gson().toJson(threeSum(nums)));
    }

}
