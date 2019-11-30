package com.hy.demo.algorithm.leetcode.threeSumClosest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/11/29 14:43
 * @Copyright:reach-life
 * @Description:
 */
public class ThreeSumClosest {

    public static int threeSumClosest(Integer[] nums,int target) {
        int len = nums.length;
        nums = sort(nums);
        int l,r;
        int ans;
        int minSub = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            l = i + 1;
            r = len - 1;
            while (l < r) {
                int tempSum = num + nums[l] + nums[r];
                int tempMinSub = Math.abs(tempSum - target);
                if (tempMinSub < minSub) {
                    minSub = tempMinSub;
                    minSum = tempSum;
                }
                if (minSub == 0) {
                    return tempSum;
                }
                l++;
                r--;
            }
        }
        return minSum;
    }

    private static Integer[] sort(Integer[] nums) {
        List<Integer> numList = Arrays.asList(nums);
        Collections.sort(numList);
        Integer[] ans = new Integer[numList.size()];
        for (int i = 0; i < ans.length ; i++) {
            ans[i] = numList.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));
    }

}
