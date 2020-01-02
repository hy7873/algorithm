package com.hy.demo.algorithm.leetcode.removeDuplicates;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/12/26 19:41
 * @Copyright:reach-life
 * @Description:
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        System.out.println(nums[i]);
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
                System.out.println(nums[i]);
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,4,5,5,6};
        int ans = removeDuplicates(nums);
        System.out.println("ans = " + ans);
    }

}
