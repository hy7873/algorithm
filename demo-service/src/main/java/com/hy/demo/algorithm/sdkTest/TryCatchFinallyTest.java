package com.hy.demo.algorithm.sdkTest;

/**
 * @Author: wanghai
 * @Date:2019/5/2 18:02
 * @Copyright:reach-life
 * @Description:
 */
public class TryCatchFinallyTest {

    public static String test1() {
        try {
            System.out.println("try");
            System.out.println(1/0);
            return "ret-try";
        } catch (Exception e) {
            System.out.println("catch");
            return "ret-catch";
        } finally {
            System.out.println("finally");
            return "ret-finally3";
        }
    }

    public static void main(String[] args) {
        System.out.println(test1());
    }

}
