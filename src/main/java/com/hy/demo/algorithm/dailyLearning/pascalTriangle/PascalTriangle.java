package com.hy.demo.algorithm.dailyLearning.pascalTriangle;

/**
 * @Author: wanghai
 * @Date:2019/11/22 11:13
 * @Copyright:reach-life
 * @Description:
 */
public class PascalTriangle {

    public static void printPascalTriangle(int n) {
        int[][] triangleData = new int[n][];
        for (int i = 0; i < n; i++) {
            triangleData[i] = new int[i + 1];
        }
        for (int i = 0; i < triangleData.length ; i++) {
            for (int j = 0; j < triangleData[i].length; j++) {
                int lotteryOdds = 1;
                for (int k = 1; k <= j; k++) {
                    lotteryOdds = lotteryOdds * (i - k + 1) / k;
                }
                triangleData[i][j] = lotteryOdds;
            }
        }
       /* for (int[] row : triangleData) {
            for (int odd : row) {
                System.out.print(odd + " ");
            }
            System.out.println();
        }*/

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < triangleData[i].length ; j++) {
                System.out.print(triangleData[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPascalTriangle(15);
    }

}
