package com.hy.demo.algorithm.daily.problem;


/**
 * @Author: wanghai
 * @Date:2019/2/15 10:16
 * @Copyright:reach-life
 * @Description:
 * A Collatz sequence in mathematics can be defined as follows. Starting with any positive integer:
    if n is even, the next number in the sequence is n / 2
    if n is odd, the next number in the sequence is 3n + 1
    It is conjectured that every such sequence eventually reaches the number 1. Test this conjecture.
    Bonus: What input n <= 1000000 gives the longest sequence?
 */
public class CollatzSeq {

    public static int getCollatzNumber(int n) {
        if (n % 2 == 0) {
            return n/2;
        } else {
            return 3*n + 1;
        }
    }


    public static int getCollatzSeqEnd(int n) {
        while (true) {
            if (n <= 1 || n > Double.MAX_VALUE) {
                return n;
            }
            n = getCollatzNumber(n);
        }
    }

    public static void printCollatzSeq(int n) {
        while (true) {
            if (n <= 1 || n > Double.MAX_VALUE) {
                System.out.print(n + " ->end ");
                break;
            }
            n = getCollatzNumber(n);
            System.out.print(n + " -> ");
        }
    }


    public static void main(String[] args) {
        int k;
        for (int i = 0; i < 1000000; i++) {
            k = getCollatzSeqEnd(i);
            if (k != 1) {
                System.out.println(String.format("k:%d,n:%d",k,i));
            }
        }

    }


    public static void main2(String[] args) {
        printCollatzSeq(997823);
    }


}
