package com.hy.demo.algorithm.dailyLearning;

import java.math.BigDecimal;

/**
 * @Author: wanghai
 * @Date:2020/2/7 18:09
 * @Copyright:reach-life
 * @Description:计算圆周率
 *
 * 1、割圆术
 *
 * 2、使用级数公式
 *
 * 3、使用概率
 * 做一个正方形正方形面积S0、做这个正方形的内切圆，内切圆面积S = pi * r ^2，用随机数产生随机点，
 * 那么点落在圆内的概率P(A) = S0/S  S0 = (2r) ^ 2   pi = 4*p(A)
 *
 */
public class PI {

    public static BigDecimal pi(int n) {
        int right = 0;
        for (int i = 0; i < n ; i++) {
            BigDecimal x = new BigDecimal(Math.random());
            BigDecimal y = new BigDecimal(Math.random());
            if ((x.multiply(x)).add((y.multiply(y))).compareTo(new BigDecimal(1)) <= 0) {
                right++;
            }
        }
        return new BigDecimal(4).multiply(new BigDecimal(right).divide(new BigDecimal(n),30,BigDecimal.ROUND_DOWN));
    }

    public static void main(String[] args) {
        System.out.println(pi(10000000));
    }

}
