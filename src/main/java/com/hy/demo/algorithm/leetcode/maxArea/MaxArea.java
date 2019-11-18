package com.hy.demo.algorithm.leetcode.maxArea;

/**
 * @Author: wanghai
 * @Date:2019/11/17 15:54
 * @Copyright:reach-life
 * @Description:
 */
public class MaxArea {

    /**
     * 暴力法
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        int temp = 0;
        for (int i = 0; i < len ; i++) {
            for (int j = i + 1; j < len ; j++) {
                temp = (j - i) * Math.min(height[i],height[j]);
                if (temp > maxArea) {
                    maxArea = temp;
                }
            }
        }
        return maxArea;
    }


    /**
     * 双指针法
     * @param height
     * @return
     */
    public static int maxAreaV2(int[] height) {
        int maxArea = 0,left = 0,right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea,Math.min(height[left],height[right]) * (right - left));
            if (height[left] < height[right]) {
                left ++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaV2(height));
    }

}
