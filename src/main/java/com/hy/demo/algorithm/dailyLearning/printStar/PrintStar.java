package com.hy.demo.algorithm.dailyLearning.printStar;

/**
 * @Author: wanghai
 * @Date:2019/11/21 17:28
 * @Copyright:reach-life
 * @Description:
 */
public class PrintStar {

    /**
     * @param n 总层数
     */
    public static void printStar(int n) {
        if (n % 2 == 0) {
            System.out.println("必须输入奇数");
            return;
        }
        //输出*的列
        int startCol = n / 2 + 1;
        int endCol = n / 2 + 1;
        //控制上半部分和下半部分
        boolean flag = true;
        //控制层数
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == startCol || j == endCol) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
            if (endCol - startCol + 1 == n) {
                flag = false;
            }
            if (flag) {
                startCol--;
                endCol++;
            } else {
                startCol++;
                endCol--;
            }
        }
    }

    public static void main(String[] args) {
        printStar(11);
    }

}
