package com.hy.demo.algorithm.leetcode.intToRoman;

/**
 * @Author: wanghai
 * @Date:2019/11/19 10:58
 * @Copyright:reach-life
 * @Description:
 */
public class IntToRoman {

    public static String intToRoman(int n) {
        int[] ints = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] romanChars = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int index = ints.length - 1;
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            int count = n / ints[index];
            while (count -- > 0) {
                ans.append(romanChars[index]);
            }
            n = n % ints[index];
            index--;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
