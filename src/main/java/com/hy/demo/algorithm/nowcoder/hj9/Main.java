package com.hy.demo.algorithm.nowcoder.hj9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: wanghai
 * @Date:2021/8/2 9:26
 * @Copyright:www.letus.com
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<Integer> array = new ArrayList<>();
            int k = 0;
            while (n > 0) {
                k = n % 10;
                if (!array.contains(k)) {
                    array.add(n % 10);
                }
                n = n / 10;
            }
            //System.out.println(array);
            int len = array.size();
            int result = 0;
            Collections.reverse(array);
            for (int i = len - 1; i >= 0 ; i--) {
                result += array.get(i) * Math.pow(Double.valueOf(10 + ""),Double.valueOf(i + ""));
            }
            System.out.println(result);
        }
    }

}
