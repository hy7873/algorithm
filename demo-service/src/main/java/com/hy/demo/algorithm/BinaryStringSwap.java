package com.hy.demo.algorithm;

/**
 * @Author: wanghai
 * @Date:2019/5/4 23:23
 * @Copyright:reach-life
 * @Description:
 */
public class BinaryStringSwap {

    public static String stringToBinary(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(Integer.toBinaryString(chars[i] - 48));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(stringToBinary("2"));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(10&1);
    }

}
