package com.hy.demo.algorithm.nowcoder.hj15;

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
            StringBuilder sb = new StringBuilder();
            int ans = 0;
            for (int i = 31; i >= 0 ; i--) {
                int k = n >>> i & 1;
                if (k == 1) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }

}
