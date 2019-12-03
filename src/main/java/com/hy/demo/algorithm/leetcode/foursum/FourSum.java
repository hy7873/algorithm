package com.hy.demo.algorithm.leetcode.foursum;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/12/3 13:31
 * @Copyright:reach-life
 * @Description:
 */
public class FourSum {

    public static List<List<Integer>> foursum(int[] nums,int target) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (nums.length <= 4) {
            return ansList;
        }
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            numList.add(nums[i]);
        }
        Collections.sort(numList);
        int len = numList.size();
        int a = 0,b = a + 1,c = b + 1,d = len - 1;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && numList.get(i) == numList.get(i - 1)) {
                continue;
            }
            int minSum = numList.get(i) + numList.get(i + 1) + numList.get(i + 2) + numList.get(i + 3);
            if (minSum > target) {
                break;
            }
            int maxSum = numList.get(i) + numList.get(len - 3) + numList.get(len - 2) + numList.get(len - 1);
            if (maxSum < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2 ; j++) {
                if (j > i + 1 && numList.get(j) == numList.get(j - 1)) {
                    continue;
                }
                int left = i + 1;
                int right = len - 1;
                int min = numList.get(i) + numList.get(j) + numList.get(left) + numList.get(left + 1);
                if (min > target) {
                    continue;
                }
                int max = numList.get(i) + numList.get(j) + numList.get(right) + numList.get(right - 1);
                if (max < target) {
                    continue;
                }
                while(left < right) {
                    int curr = numList.get(i) + numList.get(j) + numList.get(left) + numList.get(right);
                    if (curr == target) {
                        ansList.add(Arrays.asList(numList.get(i) , numList.get(j) , numList.get(left) , numList.get(right)));
                        left++;
                        while (left < right && numList.get(left) == numList.get(left - 1)) {
                            left++;
                        }
                        right--;
                        while (left < right && j < right && numList.get(right) == numList.get(right + 1) ) {
                            right--;
                        }
                    } else if (curr > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(new Gson().toJson(foursum(nums,0)));
    }

}
