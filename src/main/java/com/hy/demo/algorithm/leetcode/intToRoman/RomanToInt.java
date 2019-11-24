package com.hy.demo.algorithm.leetcode.intToRoman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public static int romanToIntV2(String roman) {
        int[] ints = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] romanChars = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int ans = 0;
        Map<String,Integer> romanIntMap = new HashMap<>();
        for (int i = 0; i < romanChars.length; i++) {
            romanIntMap.put(romanChars[i],ints[i]);
        }
        for (int i = 0; i < roman.length() ;) {
            if (i + 1 < roman.length() && romanIntMap.containsKey(roman.substring(i,i + 2))){
                ans += romanIntMap.get(roman.substring(i,i + 2));
                i = i + 2;
            } else {
                ans += romanIntMap.get(roman.substring(i, i + 1));
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToIntV2("MCMXCIV"));
    }

}
