package com.hy.demo.algorithm.dailyLearning.greedyMonkey;

import java.util.Scanner;

/**
 * @Author: wanghai
 * @Date:2019/11/21 17:09
 * @Copyright:reach-life
 * @Description:
 */
public class GreedyMonkey {

    public static int monitorPeach(int n) {
        if (n == 1)
            return 1;
        return 2 * (monitorPeach(n - 1) + 1);
    }

    public static void main(String[] args) {
        Scanner sc = null;
        while (true) {
            sc = new Scanner(System.in);
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(monitorPeach(n));
        }
        if (sc != null) {
            sc.close();
        }
    }

}
