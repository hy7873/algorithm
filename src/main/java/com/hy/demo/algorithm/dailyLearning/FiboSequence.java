package com.hy.demo.algorithm.dailyLearning;

import com.google.gson.Gson;

/**
 * @Author: wanghai
 * @Date:2019/4/3 13:59
 * @Copyright:reach-life
 * @Description:
 * 20级阶梯，每次可以上1级或者2级，总共有多少种上法
 *
 */
public class FiboSequence {

    /**
     *
     * @param N 初始个数
     * @param M 共多少项
     * @return
     */
    public static long[] getFiboSequence(int N,int M) {
        long[] a = new long[M + 1];
        a[1] = N;
        a[2] = N;
        for (int i = 3; i <= M ; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a;
    }


    public static void main(String[] args) {
        long[] a = getFiboSequence(10,24);
        System.out.println(new Gson().toJson(a));
    }

}
