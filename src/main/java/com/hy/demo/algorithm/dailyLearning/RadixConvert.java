package com.hy.demo.algorithm.dailyLearning;

/**
 * @Author: wanghai
 * @Date:2019/5/5 13:14
 * @Copyright:reach-life
 * @Description: 进制转换
 */
public class RadixConvert {


    /**
     * 数字转二进制short
     * @param n
     * @return
     */
    public static String toBinaryString(short n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 15; i >= 0 ; i--) {
            int x = n >>> i & 1;
            stringBuilder.append(x);
        }
        return stringBuilder.toString();
    }

    /**
     * 数字转二进制int
     * @param n
     * @return
     */
    public static String toBinaryString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 31; i >= 0 ; i--) {
            int x = n >>> i & 1;
            stringBuilder.append(x);
        }
        return stringBuilder.toString();
    }


    /**
     * 数字转二进制long
     * @param n
     * @return
     */
    public static String toBinaryString(long n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 63; i >= 0 ; i--) {
            long x = n >>> i & 1;
            stringBuilder.append(x);
        }
        return stringBuilder.toString();
    }

}
