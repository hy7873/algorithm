package com.hy.demo.algorithm.nowcoder.hj2;

import java.util.Scanner;

/**
 * @Author: wanghai
 * @Date:2021/8/2 10:35
 * @Copyright:www.letus.com
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s = sc.nextLine();
            String a = sc.nextLine();
            s = s.toLowerCase();
            a = a.toLowerCase();
            char[] chars = s.toCharArray();
            char[] achar = a.toCharArray();
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == achar[0]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
