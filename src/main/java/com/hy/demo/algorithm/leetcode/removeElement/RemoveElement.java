package com.hy.demo.algorithm.leetcode.removeElement;

/**
 * @Author: wanghai
 * @Date:2020/1/2 10:06
 * @Copyright:reach-life
 * @Description:
 */
public class RemoveElement {

    public static int removeElement(int[] nums,int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2,3};
        System.out.println(removeElement(nums,11));
    }

}
