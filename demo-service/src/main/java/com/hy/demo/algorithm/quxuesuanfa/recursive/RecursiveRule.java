package com.hy.demo.algorithm.quxuesuanfa.recursive;

/**
 * @Author: wanghai
 * @Date:2019/5/4 21:56
 * @Copyright:reach-life
 * @Description: 动态规划法：1、最优子结构；2、子问题重叠
 */
public class RecursiveRule {

    /**
     * fibo数列
     */
    public static int getFiboNumber(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return getFiboNumber(n - 1) + getFiboNumber(n - 2);
        }
    }


    public static void main(String[] args) {
        for (int i = 1; i < 50; i++) {
            System.out.print(getFiboNumber(i) + "  ");
        }
    }
}
