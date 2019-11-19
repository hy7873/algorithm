package com.hy.demo.algorithm.leetcode.intToRoman;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: wanghai
 * @Date:2019/11/19 20:47
 * @Copyright:reach-life
 * @Description:
 */
public class RomanToInt {

    public static int romanToInt(String roman) {
        List<String> romanStringList = Arrays.asList("I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M");
        char[] chars = roman.toCharArray();
        int temp = 0;
        int len = chars.length;
        for (int i = 0; i < len ; i++) {
            switch (chars[i]) {
                case 'I':
                    if (i < len - 1 && chars[i+1] == 'V') {
                       temp += 4;
                       i++;
                    } else if (i < len - 1 && chars[i+1] == 'X') {
                        temp += 9;
                        i++;
                    } else {
                        temp += 1;
                    }
                    break;
                case 'V':
                    temp += 5;
                    break;
                case 'X':
                    if (i < len - 1 && chars[i+1] == 'L') {
                       temp += 40;
                       i++;
                    } else if (i < len - 1 && chars[i+1] == 'C') {
                        temp += 90;
                        i++;
                    } else {
                        temp += 10;
                    }
                    break;
                case 'L':
                    temp += 50;
                    break;
                case 'C':
                    if (i < len - 1 && chars[i+1] == 'D') {
                        temp += 400;
                        i++;
                    } else if (i < len - 1 && chars[i+1] == 'M') {
                        temp += 900;
                        i++;
                    } else {
                        temp += 100;
                    }
                    break;
                case 'D':
                    temp += 500;
                    break;
                case 'M':
                    temp += 1000;
                    break;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

}
