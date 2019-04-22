package com.hy.demo.algorithm.daily.problem;

import java.util.Random;

/**
 * @Author: wanghai
 * @Date:2019/3/4 11:22
 * @Copyright:reach-life
 * @Description:
 */
public class Boggle {

    public static void main(String[] args) {
        int[][] chars = new int[4][4];
        String[] words = {"form","farm","eat"};
        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 4; j++) {
                chars[i][j] = getRandomChar();
            }
        }

        for (int i = 0; i < 4 ; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print( (char) chars[i][j] + " ");
            }
        }
    }

    public static char getRandomChar() {
        String origin = "abcdefghijklmnopqrstuvwxmyz";
        int rand = (int)(Math.random() * 100) % 26;
        return origin.charAt(rand);
    }


}
