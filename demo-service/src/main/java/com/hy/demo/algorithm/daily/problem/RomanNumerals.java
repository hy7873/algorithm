package com.hy.demo.algorithm.daily.problem;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wanghai
 * @Date:2019/2/21 10:39
 * @Copyright:reach-life
 * @Description: 罗马数字转化为阿拉伯数字
 */
public class RomanNumerals {

    public static BigDecimal getDecimalFromRomanNumberal(String romanNumeral) {
        char[] chars = romanNumeral.toCharArray();
        int ret = 0;
        for (int i = 0; i < chars.length; i++) {
            int temp = 0;
            switch (chars[i]) {
                case 'I':
                    if (i + 1 < chars.length && chars[i + 1] != 'I') {
                        temp = -1;
                    } else {
                        temp = 1;
                    }
                    break;
                case 'V':
                    temp = 5;
                    break;
                case 'X':
                    temp = 10;
                    break;
                case 'L':
                    temp = 50;
                    break;
                case 'C':
                    temp = 100;
                    break;
                case 'D':
                    temp = 500;
                    break;
                case 'M':
                    temp = 1000;
                    break;
            }
            ret += temp;
        }
        return new BigDecimal(ret);
    }


    public static void main(String[] args) {
        String romanNumeral = "XIV";
        System.out.println(getDecimalFromRomanNumberal(romanNumeral));
    }
}
