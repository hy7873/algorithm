package com.hy.demo.algorithm.nowcoder.hj15;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Author: wanghai
 * @Date:2021/8/10 13:30
 * @Copyright:www.letus.com
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String s = Integer.toBinaryString(n);
            char[] chars = s.toCharArray();
            int ans = 0;
            for (int i = 0; i < chars.length ; i++) {
                if (chars[i] == '1') {
                    ans++;
                }
            }
            System.out.println(ans);
        }


    }

    @Test
    public void test() {
        System.out.println(5>>>2);
    }

}
