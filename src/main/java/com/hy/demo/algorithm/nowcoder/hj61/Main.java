package com.hy.demo.algorithm.nowcoder.hj61;

import java.util.Scanner;

/**
 * @Author: wanghai
 * @Date:2021/8/2 13:39
 * @Copyright:www.letus.com
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = solve(m,n);
            System.out.println(k);
        }
    }

    private static int solve(int m,int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int ret = 0;
        //i表示空的个数
        for (int i = 0; i < n ; i++) {
            ret += notEmpty(m,n - i);
        }
        return ret;
    }

    /**
     * m个,要求n个不空
     * @param m
     * @param n
     * @return
     */
    private static int notEmpty(int m,int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (m < n) {
            return 0;
        }
        if (m == n) {
            return 1;
        } else {
            return solve(m - n,n);
        }
    }

}
