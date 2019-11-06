package com.hy.demo.algorithm.dailyProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wanghai
 * @Date:2019/11/6 17:02
 * @Copyright:reach-life
 * @Description:
 */
public class SymmetricString {

    public static boolean isSymmetricString(String str) {
        if (str.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < str.length() ; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSymmetricString("abcddcba"));
    }

}
